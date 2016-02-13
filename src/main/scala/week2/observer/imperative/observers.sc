import week2.observer.{BankAccount, Consolidator}

import scala.language.postfixOps

val acc1 = new BankAccount
val acc2 = new BankAccount
val consolidator = new Consolidator(List(acc1, acc2))

consolidator.totalBalance

acc1 deposit 20
acc2 deposit 30

consolidator.totalBalance

acc1 deposit 50

consolidator.totalBalance