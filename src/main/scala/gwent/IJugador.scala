package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer

trait IJugador {
  def mano: ArrayBuffer[ICarta]

  def mazo: ArrayBuffer[ICarta]
  
  def robarCarta(): ICarta

  def shuffleMazo(): Unit

}
