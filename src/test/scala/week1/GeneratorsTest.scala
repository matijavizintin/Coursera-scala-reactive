package week1

import org.scalacheck.Prop.forAll
import org.scalacheck._

/**
 * Created by Matija Vižintin
 * Date: 15. 10. 2015
 * Time: 21:42
 */
object GeneratorsTest extends Properties("List") {

    property("abc") = forAll{
        (xs: List[Int], ys: List[Int]) => (xs ++ ys).size >= xs.size
    }
}
