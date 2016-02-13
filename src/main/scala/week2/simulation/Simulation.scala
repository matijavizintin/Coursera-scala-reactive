package week2.simulation

import scala.annotation.tailrec

/**
  * Created by Matija Vižintin
  * Date: 06. 02. 2016
  * Time: 16:30
  */
trait Simulation {
    type Action = () => Unit

    case class Event(time: Int, action: Action)

    private type Agenda = List[Event]
    private var curtime = 0

    private var agenda: Agenda = List()

    def currentTime: Int = curtime

    def afterDelay(delay: Int)(block: => Unit): Unit = {
        val item = Event(currentTime + delay, () => block)
        agenda = insert(agenda, item)
    }

    def run(): Unit = {
        afterDelay(0) {
            println("*** simulation started  at " + currentTime + " ***")
        }
        loop()
    }

    private def insert(list: Agenda, item: Event): List[Event] = list match {
        case head :: tail if head.time <= item.time => head :: insert(tail, item)
        case _ => item :: list
    }

    @tailrec
    private def loop(): Unit = agenda match {
        case first :: rest =>
            agenda = rest
            curtime = first.time
            first.action()
            loop()
        case Nil =>
    }
}
