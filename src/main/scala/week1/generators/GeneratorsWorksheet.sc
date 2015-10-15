import java.util.Random

import week1.generators.{Generator, TreeGenerator}

val intGenerator = new Generator[Int] {
    val random = new Random()

    override def generate: Int = random.nextInt()
}

// random numbers
intGenerator.generate
intGenerator.generate
intGenerator.generate
intGenerator.generate
intGenerator.generate

// trees generator
val treeGenerator = TreeGenerator.trees
treeGenerator.generate
treeGenerator.generate
treeGenerator.generate

// all natural number that match a condition p
def allNaturalNumbers(p: Int => Boolean): Stream[Int] = {
    def next(n: Int): Stream[Int] = {
        Stream.cons(n, next(n + 1))
    }

    next(0).filter(p)
}

val a = allNaturalNumbers(x => x % 2 == 0)

a.take(10).toList