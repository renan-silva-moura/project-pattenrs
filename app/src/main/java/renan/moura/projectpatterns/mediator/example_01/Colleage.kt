package renan.moura.projectpatterns.mediator.example_01

interface Colleage {
    val name: String
    val type: USER_TYPE
    fun sendMessage(message: String, to: Colleage? = null)
    fun receive(message: String)
}

