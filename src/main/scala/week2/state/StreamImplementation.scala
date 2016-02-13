package week2.state

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 11:43
  */
object StreamImplementation {
    def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
        override def head = hd

        private var tlOpt: Option[Stream[T]] = None

        override def tail: Stream[T] = tlOpt match {
            case Some(x) => x
            case None => tlOpt = Some(tl); tail
        }

        protected def tailDefined: Boolean = tlOpt match {
            case None => false
            case _ => true
        }

        override def isEmpty: Boolean = head == null
    }
}
