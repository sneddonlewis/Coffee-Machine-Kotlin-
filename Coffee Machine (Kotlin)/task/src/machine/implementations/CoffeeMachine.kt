package machine.implementations

import machine.DollarMoney
import machine.Money
import machine.StockFillRequest
import machine.StockItem
import machine.contracts.VendItem
import machine.contracts.VendingMachine

class CoffeeMachine(
    private var water: Int = 0,
    private var milk: Int = 0,
    private var beans: Int = 0,
    private var cups: Int = 0,
    private var money: Money = DollarMoney(0),
    ): VendingMachine {

    override fun takeAllMoney(purse: Money): Int = this.money.moveOutAll(purse)

    override fun buy(toBuy: String, buyWith: Money): VendItem {
        val coffee = coffeeFactory(toBuy)
        buyWith.moveOut(this.money, coffee.cost)
        this.water -= coffee.water
        this.milk -= coffee.milk
        this.beans -= coffee.beans
        this.cups -= 1
        return coffee
    }

    override fun getItemsForSale(): List<String> =
        listOf(Coffee.ESPRESSO, Coffee.LATTE, Coffee.CAPPUCCINO)

    override fun getStockItems(): List<StockItem> =
        listOf(
            StockItem(makeFillPrompt("ml of water"), "water"),
            StockItem(makeFillPrompt("ml of milk"), "milk"),
            StockItem(makeFillPrompt("g of coffee beans"), "beans"),
            StockItem(makeFillPrompt("disposable cups"), "cups"),
        )

    override fun toString(): String =
        """
            The coffee machine has:
            ${this.water} ml of water
            ${this.milk} ml of milk
            ${this.beans} g of coffee beans
            ${this.cups} disposable cups
            ${this.money} of money
        """.trimIndent()

    override fun fill(stock: StockFillRequest) {
        this.fillWater(stock.getItem("water"))
            .fillMilk(stock.getItem("milk"))
            .fillBeans(stock.getItem("beans"))
            .fillCups(stock.getItem("cups"))
    }

    private fun makeFillPrompt(fillWith: String): String =
        "Write how many $fillWith you want to add:"

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