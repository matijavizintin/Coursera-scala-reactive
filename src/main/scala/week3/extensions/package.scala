package week3

/**
  * Created by Matija Vižintin
  * Date: 01. 04. 2016
  * Time: 20:09
  */
package object extensions {
    implicit class ListExtensions[T](val source: List[T]) extends AnyVal {
        def sumBy(keySelector: T => Int): Int = source.map(keySelector).sum

        private def sumBy[B](keySelector: T => B)(implicit num: Numeric[B]): B = {
            source.map(keySelector).sum
        }

    }

}
