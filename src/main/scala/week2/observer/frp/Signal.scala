package week2.observer.frp

import scala.util.DynamicVariable

/**
  * Created by Matija Vižintin
  * Date: 13. 02. 2016
  * Time: 14:44
  */
class Signal[T](expr: => T) {
    private var myExpr: () => T = _
    private var myVal: T = _
    private var observers: Set[Signal[_]] = Set()
    update(expr)

    protected def update(expr: => T): Unit = {
        myExpr = () => expr
        computeValue()
    }

    protected def computeValue(): Unit = {
        val newValue = Signal.caller.withValue(this)(myExpr())
        if (myVal != newValue) {
            myVal = newValue
            val obs = observers
            observers = Set()
            obs.foreach(_.computeValue())
        }
    }

    def apply() = {
        observers += Signal.caller.value
        assert(!Signal.caller.value.observers.contains(this), "cyclic signal definition")
        myVal
    }
}

object NoSignal extends Signal[Nothing](???) {
    override protected def computeValue(): Unit = ()
}

object Signal {
    // NOTE: this is thread-local
    private val caller = new DynamicVariable[Signal[_]](NoSignal)

    // NOTE: apply method on object enables syntax Signal(value)
    def apply[T](expr: => T) = new Signal(expr)
}
