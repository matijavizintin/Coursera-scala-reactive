package week1.json

/**
 * Created by Matija Vižintin
 * Date: 14. 10. 2015
 * Time: 19:01
 */
object JSONPrinter {

    def print(json: JSON): String = json match {
        case JBool(b) => b.toString
        case JNull => "null"
        case JNum(n) => n.toString
        case JObj(bindings) =>
            val mapped = bindings map {
                case (key, value) => "\"" + key + "\": " + print(value)
            }
            "{" + mapped mkString ", " + "}"
        case JSeq(e) => "[" + e.map(print).mkString(", ") + "]"
        case JStr(s) => s
    }
}
