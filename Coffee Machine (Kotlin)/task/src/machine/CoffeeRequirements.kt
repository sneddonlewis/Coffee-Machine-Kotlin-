package machine

class CoffeeRequirements(private val numberOfCups: Int) {
    private val water: Int = numberOfCups * 200
    private val milk : Int = numberOfCups * 50
    private val beans: Int = numberOfCups * 15

    override fun toString(): String = """
        For $numberOfCups cups of coffee you will need:
        $water ml of water
        $milk ml of milk
        $beans g of coffee beans
    """.trimIndent()
}