package machine.implementations

import machine.contracts.VendItem

internal abstract class Coffee(
    val water: Int,
    val beans: Int,
    val milk: Int,
    val _cost: Int,
    val _name: String,
): VendItem(_name, _cost) {
    companion object {
        const val ESPRESSO = "espresso"
        const val LATTE = "latte"
        const val CAPPUCCINO = "cappuccino"
    }
}

internal class Espresso() : Coffee(250, 16, 0, 4, Coffee.ESPRESSO)
internal class Latte() : Coffee(350, 20, 75, 7, Coffee.LATTE)
internal class Cappuccino() : Coffee(200, 12, 100, 6, Coffee.CAPPUCCINO)

internal fun coffeeFactory(coffee: String): Coffee =
    when (coffee) {
        Coffee.ESPRESSO -> Espresso()
        Coffee.LATTE -> Latte()
        Coffee.CAPPUCCINO -> Cappuccino()
        else -> throw IllegalArgumentException()
    }