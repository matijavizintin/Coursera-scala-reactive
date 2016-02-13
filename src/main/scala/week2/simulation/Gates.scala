package week2.simulation

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 17:08
  */
abstract class Gates extends Simulation {
    def InverterDelay: Int

    def AndGateDelay: Int

    def OrGateDelay: Int

    def inverter(in: Wire, out: Wire): Unit = {
        def invertAction(): Unit = {
            val inSignal = in.getSignal

            afterDelay(InverterDelay) {
                out setSignal !inSignal
            }
        }

        in addAction invertAction
    }

    def andGate(in1: Wire, in2: Wire, out: Wire): Unit = {
        def andAction(): Unit = {
            val inSignal1 = in1.getSignal
            val inSignal2 = in2.getSignal

            afterDelay(AndGateDelay) {
                out setSignal (inSignal1 && inSignal2)
            }
        }

        in1 addAction andAction
        in2 addAction andAction
    }

    def orGate(in1: Wire, in2: Wire, out: Wire): Unit = {
        def orAction(): Unit = {
            val inSignal1 = in1.getSignal
            val inSignal2 = in2.getSignal

            afterDelay(OrGateDelay) {
                out setSignal (inSignal1 || inSignal2)
            }
        }

        in1 addAction orAction
        in2 addAction orAction
    }

    def orGateAlt(in1: Wire, in2: Wire, out: Wire): Unit = {
        val notIn1, notIn2, notOut = new Wire
        inverter(in1, notIn1)
        inverter(in2, notIn2)
        andGate(notIn1, notIn2, notOut)
        inverter(notOut, out)
    }

    def probe(name: String, wire: Wire): Unit = {
        def probeAction(): Unit = {
            println(s"$name $currentTime value = ${wire.getSignal}")
        }
        wire addAction probeAction
    }
}
