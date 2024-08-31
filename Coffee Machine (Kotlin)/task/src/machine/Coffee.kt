package machine

abstract class Coffee(
    val water: Int,
    val beans: Int,
    val milk: Int,
    val cost: Int,
) {
    companion object {
        const val ESPRESSO = "espresso"
        const val LATTE = "latte"
        const val CAPPUCCINO = "cappuccino"
    }
}

class Espresso() : Coffee(250, 16, 0, 4)
class Latte() : Coffee(350, 20, 75, 7)
class Cappuccino() : Coffee(200, 12, 100, 6)

fun coffeeFactory(coffee: String): Coffee =
    when (coffee) {
        Coffee.ESPRESSO -> Espresso()
        Coffee.LATTE -> Latte()
        Coffee.CAPPUCCINO -> Cappuccino()
        else -> throw IllegalArgumentException()
    }