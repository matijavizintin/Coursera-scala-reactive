package week2.simulation

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 16:57
  */
class Wire {
    type Action = () => Unit

    private var signal = false
    private var actions: List[Action] = List()

    def getSignal = signal

    def setSignal(s: Boolean): Unit = {
        if (s != signal) {
            signal = s
            actions foreach (_ ())
        }
    }

    def addAction(a: Action): Unit = {
        actions = a :: actions
        a()
    }
}
