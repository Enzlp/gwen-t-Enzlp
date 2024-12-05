package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer
class Mano {
  private var mano = ArrayBuffer[Carta]()
  def add(element: Carta): Unit = {
     mano :+ element
  }
  def get(index: Int): Carta ={
    return mano(0)
  }

}
