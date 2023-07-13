package renan.moura.projectpatterns.mediator.example_02.plugins

import java.math.BigDecimal
import renan.moura.projectpatterns.mediator.example_02.mediator.CalculatorMediator
import renan.moura.projectpatterns.mediator.example_02.plugins.model.CartModel

class CartPlugin(
    private val mediator: CalculatorMediator
) : BasePlugin() {

    init {
        mediator.registerPlugin(this)
    }

    var cart = CartModel("01", mutableListOf())
        private set

    fun updateCart(cartModel: CartModel?) {
        println("Cart before Update : $cart")
        cart = cartModel!!
        println("\n\n\nCart after update  : $cart")
    }

    fun applyDiscount(discountValue: BigDecimal) {
        cart.products?.forEach {
            val newValue = it.value.subtract(discountValue)
            it.value = newValue
        }

        println("\n\n\nCart after discount  : $cart")
    }
}
