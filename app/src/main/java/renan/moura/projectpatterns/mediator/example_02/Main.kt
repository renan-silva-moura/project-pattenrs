package renan.moura.projectpatterns.mediator.example_02

import java.math.BigDecimal
import renan.moura.projectpatterns.mediator.example_02.mediator.CalculatorMediatorImplementation
import renan.moura.projectpatterns.mediator.example_02.plugins.CalculatorPlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.CartPlugin
import renan.moura.projectpatterns.mediator.example_02.plugins.CatalogPlugin

fun main() {

    val mediator = CalculatorMediatorImplementation()

    val calculatorPlugin = CalculatorPlugin(mediator)
    val cartPlugin = CartPlugin(mediator)
    val catalogPlugin = CatalogPlugin(mediator)


    calculatorPlugin.addValue(BigDecimal(10))
    calculatorPlugin.addValue(BigDecimal(23), "Escova de Dente")
    catalogPlugin.onSelectProduct()
    catalogPlugin.onSelectProduct()
    cartPlugin.applyDiscount(BigDecimal(10))
    calculatorPlugin.addValue(BigDecimal(20), "Sachê para gato")
}
