package cl.uchile.dcc
package gwent.gemObserver

trait IGemObserver[T] {
  def update(subject: Subject[T], value: T): Unit 
}
