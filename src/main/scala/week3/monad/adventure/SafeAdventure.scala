package week3.monad.adventure

import scala.util.Try

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 20:33
  */
trait SafeAdventure {
    import week3.extensions._

    var eatenByMonster: Boolean
    val treasureCost: Int

    def collectCoins(): Try[List[Coin]] = {
        Try {
            if (eatenByMonster) throw new GameOver("Eaten by a monster")
            else List(Gold(), Gold(), Silver())
        }
    }

    def buyTreasure(coins: List[Coin]): Try[Treasure] = {
        Try {
            if (coins.sumBy(x => x.value) < treasureCost) throw new GameOver("Nice try!")
            Diamond()
        }
    }
}

object SafeAdventure {
    def apply(): SafeAdventure = new SafeAdventure() {
        override var eatenByMonster: Boolean = false
        override val treasureCost: Int = 42
    }
}
