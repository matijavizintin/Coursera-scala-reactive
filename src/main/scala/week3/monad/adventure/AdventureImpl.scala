package week3.monad.adventure

import week1.monad.Try

/**
  * Created by Matija Vižintin
  * Date: 30. 03. 2016
  * Time: 20:32
  */
class AdventureImpl extends Adventure{
    override def collectionCoins(): Try[List[Coin]] = Try(List())

    override def buyTreasure(coins: List[Coin]): Try[Treasure] = Try(Treasure())
}
