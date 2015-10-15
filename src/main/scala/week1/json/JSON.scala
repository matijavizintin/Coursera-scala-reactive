package week1.json

/**
 * Created by Matija Vižintin
 * Date: 14. 10. 2015
 * Time: 18:48
 */
abstract class JSON {

}

case class JSeq(elements: List[JSON]) extends JSON

case class JObj(bindings: Map[String, JSON]) extends JSON

case class JNum(number: Double) extends JSON

case class JStr(string: String) extends JSON

case class JBool(boolean: Boolean) extends JSON

case object JNull extends JSON
