package week3.monad.adventure


/**
  * Created by Matija Vižintin
  * Date: 30. 03. 2016
  * Time: 20:01
  */
trait Adventure {
    import week3.extensions._

    val eatenByMonster: Boolean
    val treasureCost: Int

    def collectCoins(): List[Coin] = {
        if (eatenByMonster) throw new GameOver("Eaten by a monster")
        else List(Gold(), Gold(), Silver())
    }

    def buyTreasure(coins: List[Coin]): Treasure = {
        if (coins.sumBy(x => x.value) < treasureCost) throw new GameOver("Nice try!")
        Diamond()
    }
}

object Adventure {
    def apply(): Adventure = new Adventure() {
        override val eatenByMonster: Boolean = false
        override val treasureCost: Int = 42
    }
}

