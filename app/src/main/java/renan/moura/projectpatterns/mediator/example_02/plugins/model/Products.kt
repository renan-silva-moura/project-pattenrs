package renan.moura.projectpatterns.mediator.example_02.plugins.model

import java.math.BigDecimal

data class Products(
    val id: Int,
    val quantity: Int,
    var value: BigDecimal,
    val description: String?
)
