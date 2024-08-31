package machine

abstract class Coffee(
    val water: Int,
    val beans: Int,
    val milk: Int,
    val cost: Int,
) {
}

class Espresso() : Coffee(250, 16, 0, 4)
class Latte() : Coffee(350, 20, 75, 7)
class Cappuccino() : Coffee(200, 12, 100, 6)
