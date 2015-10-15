package week1

import org.scalatest.FunSuite
import week1.json.{JSONPrinter, JSONParser}

import scala.io.Source

/**
 * Created by Matija Vižintin
 * Date: 14. 10. 2015
 * Time: 18:54
 */
class JSONTest extends FunSuite {
    trait TestData {
        val jsonString = Source.fromFile("json.txt").getLines().mkString
    }

    test("deserialize and serialize") {
        new TestData {
            val jsonObject = JSONParser.parse(jsonString)
            val serialized = JSONPrinter.print(jsonObject)

            assert(jsonString === serialized)
        }
    }
}
