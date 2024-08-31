package machine.contracts

abstract class MachineStock() {
    abstract fun getStockItem(name: String): Int
}