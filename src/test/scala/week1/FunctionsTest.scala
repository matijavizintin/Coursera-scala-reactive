package week1

import org.scalatest.FunSuite

/**
 * Created by Matija Vižintin
 * Date: 14. 10. 2015
 * Time: 19:28
 */
class FunctionsTest extends FunSuite {

    test("complete functions test 1") {
        val func: String => String = {case "a" => "A"}

        val f1 = func("a")
        println(f1)

        intercept[MatchError] {
            func("b")
        }
    }

    test("partial functions test 1") {
        val func2: PartialFunction[String, String] = {case "a" => "A"}

        val f1 = func2.isDefinedAt("a")
        println("f(a) = " + f1)

        val f2 = func2.isDefinedAt("b")
        println("f(B) = " + f2)
    }
}
