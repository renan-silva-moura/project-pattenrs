package renan.moura.projectpatterns.mediator.example_02.plugins

import java.math.BigDecimal
import renan.moura.projectpatterns.mediator.example_02.mediator.CalculatorMediator
import renan.moura.projectpatterns.mediator.example_02.plugins.model.Products

class CalculatorPlugin(
    private val mediator: CalculatorMediator
) : BasePlugin() {

    init {
        mediator.registerPlugin(this)
    }

    fun addValue(value: BigDecimal, description: String? = null) {
        var productId = 0
        productId++
        val tempCart = mediator.getCart()
        tempCart?.products?.add(
            Products(
                id = productId,
                quantity = 1,
                value = value,
                description = description
            )
        )
        mediator.updateCart(tempCart)
    }
}
