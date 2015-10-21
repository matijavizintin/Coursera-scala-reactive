package week1.monad

/**
 * Created by Matija Vižintin
 * Date: 20. 10. 2015
 * Time: 21:16
 */
trait M[T] {
    def flatMap[U](f: T => M[U]): M[U]

    def unit[U](x: U): M[U]

    def map[U](f: T => U): M[U] = {
        flatMap(f andThen unit)
    }
}

