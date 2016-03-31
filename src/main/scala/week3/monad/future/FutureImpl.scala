package week3.monad.future
import scala.util.Try

/**
  * Created by Matija Vižintin
  * Date: 30. 03. 2016
  * Time: 21:12
  */
class FutureImpl[T] extends Future[T] {
    override def onComplete(callback: (Try[T]) => Unit): Unit = ???
}

class SocketImpl extends Socket {
    override def readFromMemory(): Future[Array[Byte]] = ???

    override def sentPackage(p: Array[Byte]): Future[Array[Byte]] = ???
}
