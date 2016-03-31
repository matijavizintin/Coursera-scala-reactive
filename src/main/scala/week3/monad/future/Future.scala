package week3.monad.future

import scala.util.Try

/**
  * Created by Matija Vižintin
  * Date: 30. 03. 2016
  * Time: 21:00
  */
trait Future[T] {
    def onComplete(callback: Try[T] => Unit): Unit
}

object Future {
    def apply[T](body: => T): Future[T] = new FutureImpl[T]()
}

trait Socket {
    def readFromMemory(): Future[Array[Byte]]

    def sentPackage(p: Array[Byte]): Future[Array[Byte]]
}

trait FutureAlternative[T] {
    def onComplete(success: T => Unit, failure: Throwable => Unit): Unit

    def onComplete(callback: Observer[T] => Unit): Unit
}

trait Observer[T] {
    def onNext(v: T): Unit

    def onError(error: Throwable): Unit
}
