package customBank.accounts

import customBank.Client

import java.util.Date

class AccountFactory(private val creditRate: Double, private val commissionFee: Double, private val suspiciousLimit: Double) {

    fun newDefaultAccount(client: Client, initialBalance: Double): Account {
        return DefaultAccount(client, initialBalance)
    }

    fun newDepositAccount(client: Client, initialBalance: Double, dueDate: Date): Account {
        return DepositAccount(client, initialBalance, creditRate, dueDate)
    }

    fun newCreditAccount(client: Client, initialBalance: Double, creditLimit: Double): AccountBase {
        return CreditAccount(client, initialBalance, commissionFee, creditLimit)
    }
}
