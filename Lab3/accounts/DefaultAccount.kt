package customBank.accounts

import customBank.Client
import customBank.CustomBankException

class DefaultAccount(override val client: Client,
                     initialBalance: Double) : AccountBase() {

    init {
        balance = initialBalance
    }

    override fun withdraw(value: Double) {
        if (balance < value)
            throw CustomBankException("Not enough Double")

        balance -= value
    }

    override fun applyPercent() {

    }

    override fun applyCommission() {

    }
}
