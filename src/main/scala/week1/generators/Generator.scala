package week1.generators

/**
 * Created by Matija Vižintin
 * Date: 15. 10. 2015
 * Time: 19:51
 */
trait Generator[+T] {
    parent =>

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
        override def generate: S = f(parent.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
        override def generate: S = f(parent.generate).generate
    }

    def forEach[U](f: T => U): U = {
        f(generate)
    }

    def filter(f: T => Boolean): Generator[T] = new Generator[T] {
        override def generate: T = {
            var value = parent.generate
            while (!f(value)) {
                value = parent.generate
            }
            value
        }
    }
}
