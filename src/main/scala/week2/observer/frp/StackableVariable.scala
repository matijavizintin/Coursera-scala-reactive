package week2.observer.frp

/**
  * Created by Matija Vižintin
  * Date: 13. 02. 2016
  * Time: 15:11
  */
class StackableVariable[T](init: T) {
    private var values: List[T] = List(init)

    def value: T = values.head

    // NOTE: op is evaluated with newValue value
    def withValue[R](newValue: T)(op: => R): R = {
        values = newValue :: values
        try
            op
        finally
            values = values.tail
    }
}
