import week2.simulation.SomeSimulation._
import week2.simulation.Wire

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