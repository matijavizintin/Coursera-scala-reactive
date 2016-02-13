package week2.observer

/**
  * Created by Matija Vižintin
  * Date: 13. 02. 2016
  * Time: 12:18
  */
trait Publisher {
    private var subscribers: Set[Subscriber] = Set()

    def subscribe(subscriber: Subscriber) = {
        subscribers += subscriber
    }

    def unsubscribe(subscriber: Subscriber) = {
        subscribers -= subscriber
    }

    def publish(): Unit = {
        subscribers.foreach(_.handler(this))
    }
}
