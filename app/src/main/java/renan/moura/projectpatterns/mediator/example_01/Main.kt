package renan.moura.projectpatterns.mediator.example_01

import renan.moura.projectpatterns.mediator.example_01.users.Admin
import renan.moura.projectpatterns.mediator.example_01.users.Participant

fun main() {

    val mediator = ChatRoom()
    mediator.mode = ChatRoom.Mode.PUBLIC

    val alice = Participant("Alice", mediator)
    val renan = Participant("Renan", mediator)
    val juan = Admin("Juan", mediator)
    val thiele = Admin("Thiele", mediator)


    alice.sendMessage("Hi all")
    renan.sendMessage("Oi Alice", alice)
    juan.sendMessage("Bien vinda Alice")
    thiele.sendMessage("Wellcome Alice")

    mediator.mode = ChatRoom.Mode.PRIVATE

    thiele.sendMessage("Hello Renan", renan)
    juan.sendMessage("Hola a todos")
}

