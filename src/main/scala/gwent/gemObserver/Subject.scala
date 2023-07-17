package cl.uchile.dcc
package gwent.gemObserver

trait Subject[T] {
  def addObserver(observer: IGemObserver[T]): Unit
  def notifyObservers(value: T): Unit
}
