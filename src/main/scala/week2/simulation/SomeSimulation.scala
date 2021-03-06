package week2.simulation

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 17:09
  */
object SomeSimulation extends Circuits with Parameters {
    def main(args: Array[String]) {
        val in1, in2, sum, carry = new Wire
        halfAdder(in1, in2, sum, carry)

        probe("sum", sum)
        probe("carry", carry)

        in1 setSignal true
        run()

        in2 setSignal true
        run()

        in1 setSignal false
        run()


    }
}
