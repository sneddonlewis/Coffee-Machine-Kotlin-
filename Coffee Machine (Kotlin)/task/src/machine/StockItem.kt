package machine

data class StockItem(val prompt: String, val key: String)

data class StockFillItem(val key: String, val amount: Int)

class StockFillRequest(private val items: List<StockFillItem>) {
    fun getItem(key: String): Int =
        this.items
            .filter { it.key == key }
            .map { it.amount }
            .getOrElse(0) { 0 }
}