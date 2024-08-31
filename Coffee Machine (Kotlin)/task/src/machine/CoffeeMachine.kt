package machine

class CoffeeMachine(
    private var water: Int = 0,
    private var milk: Int = 0,
    private var beans: Int = 0,
    private var cups: Int = 0,
    private var money: Money,
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

    fun fillWater(amount: Int): CoffeeMachine {
        this.water += amount
        return this
    }

    fun fillMilk(amount: Int): CoffeeMachine {
        this.milk += amount
        return this
    }

    fun fillBeans(amount: Int): CoffeeMachine {
        this.beans += amount
        return this
    }

    fun takeAllMoney(): Money = this.money.removeAll()
}