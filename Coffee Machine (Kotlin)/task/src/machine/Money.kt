package machine

abstract class Money(private var amount: Int, private val currencySymbol: Char) {

    override fun toString(): String = "$currencySymbol$amount"

    fun moveOut(moveTo: Money, amountToMove: Int): Unit {
        moveTo.amount += amountToMove
        this.amount -= amountToMove
    }

    fun moveOutAll(moveTo: Money): Int {
        val movedAmount = this.amount
        this.moveOut(moveTo, movedAmount)
        return movedAmount
    }

    val value: Int
        get() = this.amount
}

class DollarMoney(private val _amount: Int = 0) : Money(_amount, '$')
