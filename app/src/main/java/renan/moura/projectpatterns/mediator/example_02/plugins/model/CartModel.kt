package renan.moura.projectpatterns.mediator.example_02.plugins.model

data class CartModel(
    val id: String,
    var products: MutableList<Products>? = null
)
