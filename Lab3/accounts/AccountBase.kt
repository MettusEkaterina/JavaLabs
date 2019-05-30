package customBank.accounts

import customBank.CustomBankException

abstract class AccountBase : Account {
    override var balance: Double = 0.0
        protected set

    final override fun deposit(amount: Double) {
        balance = balance.plus(amount)
    }

    final override fun transfer(amount: Double, other: Account) {
        withdraw(amount)
        other.deposit(amount)
    }

    final override fun withdraw(amount: Double){
        checkCanWithdraw()
        performWithdraw()
    }

    abstract override fun applyPercent()

    abstract override fun applyCommission()
}
