package week1.generators

/**
 * Created by Matija Vižintin
 * Date: 15. 10. 2015
 * Time: 20:53
 */
object TreeGenerator {

    def leafs: Generator[Leaf] = for (int <- Generators.intGenerator) yield Leaf(int)

    def inners: Generator[Inner] = for {
        left <- trees
        right <- trees
    } yield Inner(left, right)

    def trees: Generator[Tree] = for {
        leaf <- Generators.booleanGenerator2
        tree <- if (leaf) leafs else inners
    } yield tree
}
