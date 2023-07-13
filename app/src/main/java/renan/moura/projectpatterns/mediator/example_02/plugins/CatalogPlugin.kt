package renan.moura.projectpatterns.mediator.example_02.plugins

import java.math.BigDecimal
import kotlin.random.Random
import renan.moura.projectpatterns.mediator.example_02.mediator.CalculatorMediator
import renan.moura.projectpatterns.mediator.example_02.plugins.model.Products

class CatalogPlugin(
    private val mediator: CalculatorMediator
) : BasePlugin() {

    private val listOfProducts = listOf<Products>(
        Products(
            id = 0,
            quantity = 1,
            value = BigDecimal(10),
            description = "Camiseta"
        ),
        Products(
            id = 1,
            quantity = 20,
            value = BigDecimal(1.50),
            description = "Coca-Cola"
        ),
        Products(
            id = 2,
            quantity = 5,
            value = BigDecimal(3.50),
            description = "Pão na chapa"
        ),
        Products(
            id = 3,
            quantity = 2,
            value = BigDecimal(150),
            description = "Ração para gatos"
        ),
        Products(
            id = 4,
            quantity = 1,
            value = BigDecimal(1500),
            description = "Pneu de carro"
        )
    )

    init {
        mediator.registerPlugin(this)
    }

    fun onSelectProduct() {
        val random = Random.nextInt(0, listOfProducts.size)
        val product = listOfProducts[random]
        val tempCart = mediator.getCart()
        tempCart?.products?.add(product)
        mediator.updateCart(tempCart)
    }
}
