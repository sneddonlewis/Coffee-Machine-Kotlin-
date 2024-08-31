package machine

abstract class MachineStock() {
    abstract fun getStockItem(name: String): Int
}