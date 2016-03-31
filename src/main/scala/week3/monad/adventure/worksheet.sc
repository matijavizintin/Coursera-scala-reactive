import week1.monad.{Failure, Success, Try}
import week3.monad.adventure.{Adventure, Coin, Treasure}

val adventure = new Adventure {
    override def collectionCoins(): Try[List[Coin]] = Try(List(Coin(), Coin(), Coin()))

    override def buyTreasure(coins: List[Coin]): Try[Treasure] = Try(Treasure())
}

val coins: Try[List[Coin]] = adventure.collectionCoins()

val treasure: Try[Treasure] = coins match {
    case Success(cs) => adventure.buyTreasure(cs)
    case failure@Failure(e) => failure
}

val treasure2: Try[Treasure] = adventure.collectionCoins().flatMap(coins => {
    adventure.buyTreasure(coins)
})

val treasure3: Try[Treasure] = for {
    coins <- adventure.collectionCoins()
    treasure <- adventure.buyTreasure(coins)
} yield treasure