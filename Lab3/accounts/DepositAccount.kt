package customBank.accounts

import customBank.Client
import customBank.CustomBankException

import java.util.Date

class DepositAccount(override val client: Client,
                     private val startValue: Double,
                     private val percent: Double,
                     private val dueDate: Date) : AccountBase() {

    init {
        balance = startValue
    }

    override fun withdraw(amount: Double) {
        if (balance < amount)
            throw CustomBankException("")

        balance = balance.minus(amount)
    }

    override fun applyPercent() {
        balance += startValue * percent
    }

    override fun applyCommission() {

    }
}
