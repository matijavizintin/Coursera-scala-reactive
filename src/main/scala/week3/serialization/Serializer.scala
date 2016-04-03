package week3.serialization

/**
  * Created by Matija Vižintin
  * Date: 03. 04. 2016
  * Time: 15:25
  */
class Serializer {
    def toBinary(obj: AnyRef): Array[Byte] = {
        obj.toString.getBytes
    }
}

object Serializer {
    def apply(): Serializer = new Serializer()
}
