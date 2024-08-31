package machine

class CoffeeMachine(
    private var water: Int = 0,
    private var milk: Int = 0,
    private var beans: Int = 0,
    private var cups: Int = 0,
    private var money: Money = DollarMoney(0),
    ) {

    companion object {
        const val CUPS_PER_WATER: Int = 200
        const val CUPS_PER_MILK: Int = 50
        const val CUPS_PER_BEANS: Int = 15
    }

    val numberOfCups: Int
        get() =
            minOf(
                this.beans / CUPS_PER_BEANS,
                this.water / CUPS_PER_WATER,
                this.milk / CUPS_PER_MILK,
                this.cups
            )

    fun takeAllMoney(purse: Money): Int = this.money.moveOutAll(purse)

    fun buy(coffee: Coffee, buyWith: Money): Unit = buyWith.moveOut(this.money, coffee.cost)

    override fun toString(): String =
        """
            The coffee machine has:
            ${this.water} ml of water
            ${this.milk} ml of milk
            ${this.beans} g of coffee beans
            ${this.cups} disposable cups
            ${this.money} of money
        """.trimIndent()

    fun fill(waterFill: Int, milkFill: Int, beansFill: Int, cupsFill: Int): CoffeeMachine =
        this.fillWater(waterFill)
            .fillMilk(milkFill)
            .fillBeans(beansFill)
            .fillCups(cupsFill)

    private fun fillWater(amount: Int): CoffeeMachine {
        this.water += amount
        return this
    }

    private fun fillMilk(amount: Int): CoffeeMachine {
        this.milk += amount
        return this
    }

    private fun fillBeans(amount: Int): CoffeeMachine {
        this.beans += amount
        return this
    }

    private fun fillCups(amount: Int): CoffeeMachine {
        this.cups += amount
        return this
    }
}