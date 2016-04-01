package week3.monad.adventure

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 19:57
  */
class Coin(var value: Int) {

}

case class Gold() extends Coin(value = 200) {}
case class Silver() extends Coin(value = 100) {}
