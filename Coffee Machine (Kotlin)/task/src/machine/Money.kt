package machine

abstract class Money(private var amount: Int, private val currencySymbol: Char) {

    abstract fun removeAll(): Money

    override fun toString(): String = "$currencySymbol$amount"

    fun moveOut(moveTo: Money): Unit {
        moveTo.amount += this.amount
        this.amount -= moveTo.amount
    }

    val value: Int
        get() = this.amount
}

class DollarMoney(private val _amount: Int) : Money(_amount, '$') {
    override fun removeAll(): Money {
        val removal = DollarMoney(0)
        this.moveOut(removal)
        return removal
    }
}

