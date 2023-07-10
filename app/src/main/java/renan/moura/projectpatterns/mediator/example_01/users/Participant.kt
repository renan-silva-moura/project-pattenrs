package renan.moura.projectpatterns.mediator.example_01.users

import renan.moura.projectpatterns.mediator.example_01.ChatRoomMediator
import renan.moura.projectpatterns.mediator.example_01.Colleage
import renan.moura.projectpatterns.mediator.example_01.ParticipantName
import renan.moura.projectpatterns.mediator.example_01.USER_TYPE

class Participant(
    override val name: ParticipantName,
    private val chatRoomMediator: ChatRoomMediator
) : Colleage {

    override val type: USER_TYPE
        get() = USER_TYPE.NORMAL

    init {
        chatRoomMediator.registerParticipant(this)
    }

    override fun sendMessage(message: String, to: Colleage?) {
        chatRoomMediator.send(message, this, to)
    }

    override fun receive(message: String) {
        println("[$name] gets: $message")
    }
}
