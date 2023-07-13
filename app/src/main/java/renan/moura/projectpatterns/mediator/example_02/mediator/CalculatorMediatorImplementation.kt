package renan.moura.projectpatterns.mediator.example_02.mediator

import renan.moura.projectpatterns.mediator.example_02.plugins.BasePlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.CalculatorPlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.CartPlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.CatalogPlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.model.CartModel

class CalculatorMediatorImplementation : CalculatorMediator {

    private var calculatorPlugin: CalculatorPlugin? = null
    private var cartPlugin: CartPlugin? = null
    private var catalogPlugin: CatalogPlugin? = null

    override fun registerPlugin(basePlugin: BasePlugin) {
        when (basePlugin) {
            is CalculatorPlugin -> calculatorPlugin = basePlugin
            is CartPlugin -> cartPlugin = basePlugin
            is CatalogPlugin -> catalogPlugin = basePlugin
        }
    }

    override fun detachPlugin(basePlugin: BasePlugin) {
        when (basePlugin) {
            is CalculatorPlugin -> calculatorPlugin = null
            is CartPlugin -> cartPlugin = null
            is CatalogPlugin -> catalogPlugin = null
        }
    }

    override fun getCart(): CartModel? = this.cartPlugin?.cart

    override fun updateCart(cartModel: CartModel?) {
        this.cartPlugin?.updateCart(cartModel)
    }
}
