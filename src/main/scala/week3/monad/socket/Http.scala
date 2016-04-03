package week3.monad.socket

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 21:13
  */
object Http {
    def apply(url: String, request: Request): Future[Response] = {
        // dummy, return request
        Future(Response(request.body))
    }
}

trait Request {
    def body: Array[Byte]
}

object Request {
    def apply(bytes: Array[Byte]): Request = new Request(){
        override def body: Array[Byte] = bytes
    }
}

trait Response {
    def isOk: Boolean
    def body: Array[Byte]
}

object Response {
    def apply(bytes: Array[Byte]): Response = new Response {
        override def body: Array[Byte] = bytes

        override def isOk: Boolean = true
    }
}

