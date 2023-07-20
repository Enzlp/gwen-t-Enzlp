package cl.uchile.dcc
package gwent.gemObserver

trait Subject[T] {
  /** Método para acceder a la lista de observers del Subject */
  def showObservers: List[IGemObserver[T]]
  /** Método para agregar un observer a la la lista de observers*/
  def addObserver(observer: IGemObserver[T]): Unit
  /** Método que notifica a los observers de un cambio en la información del subject */
  def notifyObservers(value: T): Unit
}
