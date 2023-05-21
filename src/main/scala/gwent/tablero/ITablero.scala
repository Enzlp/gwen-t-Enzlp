package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.Carta
import scala.collection.mutable.ArrayBuffer
trait ITablero {
  def jugarCarta(card: Carta): Unit
  def zonaClima: ArrayBuffer[Carta]

  def zonaCC: ArrayBuffer[Carta]

  def zonaCA: ArrayBuffer[Carta]
  
  def zonaCD: ArrayBuffer[Carta]


}
