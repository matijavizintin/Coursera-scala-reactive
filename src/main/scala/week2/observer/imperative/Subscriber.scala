package week2.observer

/**
  * Created by Matija Vižintin
  * Date: 13. 02. 2016
  * Time: 12:19
  */
trait Subscriber {

    def handler(publisher: Publisher)
}
