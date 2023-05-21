package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer
import gwent.cartas.Carta

trait IJugador {
  def mano: ArrayBuffer[Carta]

  def mazo: ArrayBuffer[Carta]
  
  def robarCarta(): Carta

  def shuffleMazo(): Unit

  def jugarCarta(card: Carta): Unit

}
