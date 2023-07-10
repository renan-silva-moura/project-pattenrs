package renan.moura.projectpatterns.mediator.example_01

typealias ParticipantName = String

interface ChatRoomMediator {
    fun registerParticipant(participant: Colleage)
    fun send(message: String, from: Colleage, to: Colleage? = null)
}

