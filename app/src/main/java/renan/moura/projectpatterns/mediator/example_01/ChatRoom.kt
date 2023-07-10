package renan.moura.projectpatterns.mediator.example_01

class ChatRoom : ChatRoomMediator {

    private val participants = mutableListOf<Colleage>()

    enum class Mode {
        PUBLIC, // every message is delivered to every participant
        PRIVATE, // only messages with recipient will be delivered
        MIXED, // both direct messages and public ones will be delivered,
        ADMIN // chat only for admins
    }

    var mode: Mode = Mode.PRIVATE

    override fun registerParticipant(participant: Colleage) {
        participants.add(participant)
    }

    override fun send(message: String, from: Colleage, to: Colleage?) {
        when (mode) {
            Mode.PUBLIC -> removeSender(from).forEach { it.receive("${from.name} says: $message") }
            Mode.PRIVATE -> removeSender(from).find { it == to }?.receive("${from.name} says: $message")
            Mode.MIXED -> {
                if (to == null) participants.forEach { it.receive("${from.name} says: $message") }
                else participants.find { it == to }?.receive("${from.name} says: $message")
            }

            Mode.ADMIN -> {
                participants.find { it.type == USER_TYPE.ADMIN }?.receive("${from.name} #ADMIN says: $message")
            }
        }
    }

    private fun removeSender(from: Colleage): List<Colleage> {
        val newList = participants.toMutableList()
        newList.remove(from)
        return newList
    }
}
