package customBank.accounts

import customBank.Client
import customBank.CustomBankException

class CreditAccount(override val client: Client,
                    value: Double,
                    private val creditCommission: Double,
                    private val creditLimit: Double) : AccountBase() {

    init {
        balance = value
    }

    override fun withdraw(amount: Double) {
        if (balance - amount < -creditLimit)
            throw CustomBankException("Out of limit")

        balance = balance.minus(amount)
        if (balance < 0)
            balance -= creditCommission
    }

    override fun applyPercent() {

    }

    override fun applyCommission() {
        balance -= creditCommission
    }
}
