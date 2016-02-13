package week1

import org.scalacheck.Prop.{BooleanOperators, forAll}
import org.scalacheck._

/**
  * Created by Matija Vižintin
  * Date: 15. 10. 2015
  * Time: 21:42
  */
object GeneratorsTest extends Properties("List") {

    property("size test 1") = forAll {
        (xs: List[Int], ys: List[Int]) => (xs ++ ys).size >= xs.size
    }

    property("size test 2") = forAll {
        (xs: List[Int], ys: List[Int]) => (xs ++ ys).size > xs.size
    }

    property("sqrt") = forAll {
        (d: Int) => math.sqrt(d * d) == d
    }

    // pick only negative values
    property("better sqrt") = forAll {
        (d: Int) => (d < 0) ==> (math.sqrt(d * d) == d)
    }

    // generate test cases
    val integers = Gen.choose(0, 100)
    property("integers") = forAll(integers) {
        i => i >= 0 && i <= 100
    }
}
