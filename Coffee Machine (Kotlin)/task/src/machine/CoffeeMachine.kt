package machine

class CoffeeMachine(
    private var water: Int = 0,
    private var milk: Int = 0,
    private var beans: Int = 0,
    private var cups: Int = 0,
    private var money: Money = DollarMoney(0),
    ) {

    fun takeAllMoney(purse: Money): Int = this.money.moveOutAll(purse)

    fun buy(toBuy: CoffeeType, buyWith: Money): Coffee {
        val coffee = coffeeFactory(toBuy)
        buyWith.moveOut(this.money, coffee.cost)
        this.water -= coffee.water
        this.milk -= coffee.milk
        this.beans -= coffee.beans
        this.cups -= 1
        return coffee
    }

    override fun toString(): String =
        """
            The coffee machine has:
            ${this.water} ml of water
            ${this.milk} ml of milk
            ${this.beans} g of coffee beans
            ${this.cups} disposable cups
            ${this.money} of money
        """.trimIndent()

    fun fill(stock: MachineStock): CoffeeMachine =
        this.fillWater(stock.getStockItem("water"))
            .fillMilk(stock.getStockItem("milk"))
            .fillBeans(stock.getStockItem("beans"))
            .fillCups(stock.getStockItem("cups"))

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