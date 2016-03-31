package week3.monad.adventure

import week1.monad.Try

/**
  * Created by Matija Vižintin
  * Date: 30. 03. 2016
  * Time: 20:01
  */
trait Adventure {
    def collectionCoins(): Try[List[Coin]]

    def buyTreasure(coins: List[Coin]): Try[Treasure]
}

case class Coin() {}

case class Treasure() {}

