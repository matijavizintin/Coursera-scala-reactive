package week2.observer

/**
  * Created by Matija Vižintin
  * Date: 13. 02. 2016
  * Time: 12:30
  */
class Consolidator(observed: List[BankAccount]) extends Subscriber {
    observed.foreach(_.subscribe(this))

    private var total: Int = _      // value is initially uninitialized
    compute()

    def totalBalance = total

    private def compute(): Unit = {
        total = observed.map(_.currentBalance).sum
    }

    override def handler(publisher: Publisher): Unit = compute()
}
