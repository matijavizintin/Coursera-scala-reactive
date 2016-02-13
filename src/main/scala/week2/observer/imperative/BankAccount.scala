package week2.observer

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 11:20
  */
class BankAccount extends Publisher {
    private var balance = 0

    def currentBalance: Int = balance

    def deposit(amount: Int): Unit = if (amount > 0) {
        balance += amount
        publish()
    }

    def withdraw(amount: Int): Unit =
        if (0 < amount && amount <= balance) {
            balance -= amount
            publish()
        }
        else throw new Error("Not enough funds")
}
