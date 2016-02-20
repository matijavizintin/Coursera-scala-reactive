package week2.observer.frp

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 11:20
  */
class BankAccount {
    val balance = Var(0)

    def deposit(amount: Int): Unit =
        if (amount > 0) {
            val b = balance()
            balance() = b + amount
        }

    def withdraw(amount: Int): Unit =
        if (0 < amount && amount <= balance()) {
            val b = balance()
            balance() = b - amount
        }
        else throw new Error("Not enough funds")
}
