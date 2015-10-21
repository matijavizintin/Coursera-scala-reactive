package week1

import org.scalatest.FunSuite
import week1.monad.{Success, Try}

/**
 * Created by Matija Vižintin
 * Date: 20. 10. 2015
 * Time: 21:53
 */
class MonadTest extends FunSuite {
    test("simple test") {
        val xs = for {
            x <- computeX
            y <- computeY
        } yield (x,y)

        println(xs)
    }

    def computeX: List[Try[Int]] = {
        List(Success(5), Success(12), Success(-5), Success(4))
    }

    def computeY: List[Try[Int]] = {
        List(Success(6), Success(11), Success(12), Success(-15), Success(0))
    }

    def f(x: Int, y: Int): Try[Int] = {
        Success(x + y)
    }
}
