import week3.monad.future.SocketImpl

import scala.util.{Failure, Success}

val socket = new SocketImpl()

val packet = socket.readFromMemory()

val confirmation = packet.onComplete {
    case Success(p) => socket.sentPackage(p)
    case Failure(t) => t
}