package week3.monad.socket

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 21:04
  */
trait Socket {
    def readFromMemory(): Array[Byte] = Array(1.toByte, 2.toByte, 3.toByte)
    def sendToEurope(packet: Array[Byte]): Array[Byte] = Array(5.toByte, 6.toByte, 7.toByte, 8.toByte)
}

object Socket {
    def apply(): Socket = new Socket() {}
}

