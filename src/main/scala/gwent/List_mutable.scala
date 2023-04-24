package cl.uchile.dcc
package gwent

trait List_mutable {
  def get(index: Int): Any

  def add(element: Any): Unit // add last

  def getSize(): Int

  
}
