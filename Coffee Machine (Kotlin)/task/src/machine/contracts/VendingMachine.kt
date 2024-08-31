package machine.contracts

import machine.*

interface VendingMachine {
    fun takeAllMoney(purse: Money): Int
    fun buy(toBuy: String, buyWith: Money): Coffee
    fun fill(stock: MachineStock): CoffeeMachine
    fun getItemsForSale(): List<String>
}