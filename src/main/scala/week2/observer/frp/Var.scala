package week2.observer.frp

/**
  * Created by Matija Vižintin
  * Date: 13. 02. 2016
  * Time: 15:18
  */
class Var[T](expr: => T) extends Signal[T](expr) {
    override def update(expr: => T): Unit = super.update(expr)
}

object Var {
    // NOTE: apply method on object enables syntax Var(value)
    def apply[T](expr: => T) = new Var(expr)
}
