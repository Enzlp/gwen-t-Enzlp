package cl.uchile.dcc
package gwent.gemObserver

abstract class AbstractSubject[T] extends Subject[T]{
  private var observers: List[IGemObserver[T]] = Nil
  override def addObserver(observer: IGemObserver[T]): Unit = {
    observers = observer :: observers
  }

  override def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }
}
