package renan.moura.projectpatterns.mediator.example_01.users

import renan.moura.projectpatterns.mediator.example_01.ChatRoomMediator
import renan.moura.projectpatterns.mediator.example_01.Colleage
import renan.moura.projectpatterns.mediator.example_01.USER_TYPE

class Admin(
    override val name: String,
    private val mediator: ChatRoomMediator
) : Colleage {

    init {
        mediator.registerParticipant(this)
    }

    override val type: USER_TYPE
        get() = USER_TYPE.ADMIN

    override fun sendMessage(message: String, to: Colleage?) {
        mediator.send(message, this, to)
    }

    override fun receive(message: String) {
        println("[$name] gets: $message")
    }
}
