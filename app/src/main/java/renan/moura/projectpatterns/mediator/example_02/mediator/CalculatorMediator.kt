package renan.moura.projectpatterns.mediator.example_02.mediator

import renan.moura.projectpatterns.mediator.example_02.plugins.BasePlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.model.CartModel

interface CalculatorMediator {

    fun registerPlugin(basePlugin: BasePlugin)
    fun detachPlugin(basePlugin: BasePlugin)
    fun getCart(): CartModel?
    fun updateCart(cartModel: CartModel?)
}
