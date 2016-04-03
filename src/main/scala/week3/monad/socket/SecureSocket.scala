package week3.monad.socket

import week3.serialization.Serializer

import scala.collection.immutable.Queue
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 21:11
  */
trait SecureSocket {
    val serializer = Serializer()

    val memory = Queue[Email](
        Email(from = "Person1", to = "Person2"),
        Email(from = "Person3", to = "Person4"),
        Email(from = "Person5", to = "Person6")
    )

    def readFromMemory(): Future[Array[Byte]] = {
        Future {
            val email = memory.dequeue
            serializer.toBinary(email)
        }
    }

    def sendToEurope(packet: Array[Byte]): Future[Array[Byte]] = {
        Http("mail.server.eu", Request(packet)).filter(_.isOk).map(_.body)
    }

    def sendTo(url: String, packet: Array[Byte]): Future[Array[Byte]] = {
        Http(url, Request(packet)).filter(_.isOk).map(_.body)
    }

    def sendToSafe1(packet: Array[Byte]): Future[Array[Byte]] = {
        sendTo("europe", packet) recoverWith {
            case europeError => sendTo("usa", packet) recover {
                case usaError => usaError.getMessage.getBytes
            }
        }
    }

    def sendToSafe2(packet: Array[Byte]): Future[Array[Byte]] = {
        sendTo("europe", packet) fallbackTo {
            sendTo("usa", packet) recover {
                case europeError => europeError.getMessage.getBytes
            }
        }
    }

    def sendToAndBackup(packet: Array[Byte]): Future[(Array[Byte], Array[Byte])] = {
        val europeConfirm = sendTo("europe", packet)
        val usaConfirm = sendTo("usa", packet)
        europeConfirm.zip(usaConfirm)
    }
}

object SecureSocket {
    def apply(): SecureSocket = new SecureSocket() {}
}
