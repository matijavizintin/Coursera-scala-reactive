import week3.monad.adventure.{Adventure, SafeAdventure, Treasure}

import scala.util.{Failure, Success, Try}

val adventure = Adventure()
val coins = adventure.collectCoins()
adventure.buyTreasure(coins)

val safeAdventure = SafeAdventure()
val safeCoins = safeAdventure.collectCoins()
val safeTreasure = safeCoins match {
    case Success(cs) => safeAdventure.buyTreasure(cs)
    case Failure(e) => Failure(e)
}

val safeTreasure2: Try[Treasure] = safeCoins.flatMap(cs => safeAdventure.buyTreasure(cs))

val safeTreasure3 = for {
    coins <- safeAdventure.collectCoins()
    treasure <- safeAdventure.buyTreasure(coins)
} yield treasure

