package week3.monad.socket

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 21:03
  */
class Email(val from: String, val to: String) {

}

object Email {
    def apply(from: String, to: String): Email = new Email(from, to)
}
