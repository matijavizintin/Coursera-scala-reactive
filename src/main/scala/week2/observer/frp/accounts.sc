import week2.observer.frp.{BankAccount, Signal}

object accounts {
    def consolidated(accounts: List[BankAccount]): Signal[Int] =
        Signal(accounts.map(_.balance()).sum)
}

val a = new BankAccount()
val b = new BankAccount()
val c = accounts.consolidated(List(a, b))

c()
a deposit 20
c()
b deposit 30
c()

val exchange = Signal(380)
val inDollar = Signal(c() * exchange())

inDollar()
b withdraw 10
inDollar()