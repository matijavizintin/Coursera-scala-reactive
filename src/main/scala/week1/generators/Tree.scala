package week1.generators

/**
 * Created by Matija Vižintin
 * Date: 15. 10. 2015
 * Time: 20:50
 */
trait Tree

case class Inner(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree
