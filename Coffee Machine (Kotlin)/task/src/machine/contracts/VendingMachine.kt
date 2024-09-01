package machine.contracts

import machine.*

interface VendingMachine {
    fun takeAllMoney(purse: Money): Int
    fun buy(toBuy: String, buyWith: Money): VendResult
    fun fill(stock: StockFillRequest)
    fun getItemsForSale(): List<String>
    fun getStockItems(): List<StockItem>
}