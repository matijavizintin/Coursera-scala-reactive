package week1.monad

import scala.util.control.NonFatal

/**
 * Created by Matija Vižintin
 * Date: 20. 10. 2015
 * Time: 21:34
 */
abstract class Try[+T] {
    def flatMap[U](f: T => Try[U]): Try[U] = this match {
        case Success(x) => try f(x) catch {
            case NonFatal(ex) => Failure(ex)
        }
        case fail: Failure => fail
    }

    def map[U](f: T => U): Try[U] = this match {
        case Success(x) => Try(f(x))
        case fail: Failure => fail
    }
}

case class Success[T](x: T) extends Try[T]

case class Failure(ex: Throwable) extends Try[Nothing]

object Try {
    def apply[U](expr: => U): Try[U] = {
        try Success(expr)
        catch {
            case NonFatal(ex) => Failure(ex)
        }
    }
}