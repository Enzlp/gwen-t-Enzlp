package cl.uchile.dcc
package gwent.gemObserver

trait IGemObserver[T] {
  /** Método para actualizar la información del observer en base a un cambio en el subject*/
  def update(subject: Subject[T], value: T): Unit 
}
