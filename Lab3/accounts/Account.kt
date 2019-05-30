package customBank.accounts

import customBank.Client
import customBank.CustomBankException

interface Account {
    val client: Client
    val balance: Double
    @Throws(CustomBankException::class)
    fun withdraw(amount: Double)

    fun deposit(amount: Double)
    @Throws(CustomBankException::class)
    fun transfer(amount: Double, other: Account)

    @Throws(CustomBankException::class)
    fun applyPercent()

    @Throws(CustomBankException::class)
    fun applyCommission()
}
