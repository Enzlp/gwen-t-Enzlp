package cl.uchile.dcc
package gwent

class Mano extends List_mutable {
  private var size: Int = 0
  private var mano: Array[Carta] = new Array[Carta](10)
  def add(element: Carta): Unit = {
    mano.add(getSize(), element)
  }



}
