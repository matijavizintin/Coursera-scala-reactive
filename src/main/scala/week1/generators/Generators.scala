package week1.generators

import java.util.Random

/**
 * Created by Matija Vižintin
 * Date: 15. 10. 2015
 * Time: 19:55
 */
object Generators {
    lazy val intGenerator = IntGenerator
    lazy val booleanGenerator = BooleanGenerator
    lazy val pairsGenerator = PairsGenerator

    // getters
//    def getIntGenerator = intGenerator
//    def getBooleanGenerator = booleanGenerator
//    def getBooleanGenerator2 = booleanGenerator2
//    def getPairsGenerator = pairsGenerator

    // generators
    case object IntGenerator extends Generator[Int] {
        val random = new Random()

        override def generate: Int = random.nextInt()
    }

    case object BooleanGenerator extends Generator[Boolean] {
        override def generate: Boolean = intGenerator.generate > 0
    }

    case object PairsGenerator extends Generator[(Int, Int)] {
        override def generate: (Int, Int) = (intGenerator.generate, intGenerator.generate)
    }

    // generators v2
    lazy val booleanGenerator2 = for (x: Int <- intGenerator) yield x > 0

    def getPairsGenerator2[T, U](t: Generator[T], u: Generator[U]) = {
        for {
            x <- t
            y <- u
        } yield (x, y)
    }

    def single[T](x: T): Generator[T] = new Generator[T] {
        override def generate: T = x
    }

    def choose(lo: Int, hi: Int): Generator[Int] = for (x <- intGenerator) yield lo + x % (hi - lo)

    def oneOf[T](xs: T*): Generator[T] = for (index <- choose(0, xs.length)) yield xs(index)

    // list generator
    def lists: Generator[List[Int]] = {
        for {
            isEmpty <- booleanGenerator2
            list <- if (isEmpty) emptyLists else nonEmptyLists
        } yield list
    }

    def emptyLists: Generator[List[Int]] = single(Nil)

    def nonEmptyLists: Generator[List[Int]] = for {
        head <- intGenerator
        tail <- lists
    } yield head :: tail

}

