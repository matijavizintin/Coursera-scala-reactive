import week2.state.{BankAccount, StreamImplementation}

import scala.util.control.NonFatal

val account = new BankAccount
account deposit 50
account withdraw 20
account withdraw 20

try account withdraw 20
catch {
    case NonFatal(e) => println(e)
}

val tail = Stream.range(2, 5)
val stream = StreamImplementation.cons(1, tail)

for (t <- stream) {
    println(t)
}