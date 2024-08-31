package machine

class CoffeeMachineStock(private val water: Int, private val milk: Int, private val beans: Int, private val cups: Int): MachineStock() {
    override fun getStockItem(name: String): Int =
        when (name) {
            "water" -> water
            "milk" -> milk
            "beans" -> beans
            "cups" -> cups
            else -> 0
        }
}