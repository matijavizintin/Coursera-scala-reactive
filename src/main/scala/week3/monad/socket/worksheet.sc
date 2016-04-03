import week3.monad.socket.{Http, Request, SecureSocket, Socket}
import week3.serialization.Serializer

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

val socket = Socket()
val array = socket.readFromMemory()
val response = socket.sendToEurope(array)

val secureSocket = SecureSocket()
val packet = secureSocket.readFromMemory()
val confirmation: Unit = packet onComplete {
    case Success(p) => secureSocket.sendToEurope(p)
    case Failure(e) => throw e
}

val confirmation2: Future[Array[Byte]] = packet.flatMap(p => secureSocket.sendToEurope(p))

val confirmation3: Future[Array[Byte]] = for {
    packet <- secureSocket.readFromMemory()
    conf <- secureSocket.sendToSafe2(packet)
} yield conf


val request = Request(Serializer().toBinary("dummy"))
val httpResponse = Http("europe", request)