package week2.state

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 11:20
  */
class BankAccount {
    private var balance = 0

    def deposit(amount: Int): Unit = if (amount > 0) balance += amount

    def withdraw(amount: Int): Int =
        if (0 < amount && amount <= balance) {
            balance -= amount
            balance
        }
        else throw new Error("Not enough funds")
}
