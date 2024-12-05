package cl.uchile.dcc
package gwent.tablero

import scala.collection.mutable.ArrayBuffer
import gwent.cartas.Carta
trait ITableroClima {
  /**Método de acceso a la zona de clima de al parte del tablero que comparten los jugadores
   */
  def zonaClima: ArrayBuffer[Carta]

  /**Método que recibe la carta para posicionarla en el tablero
   */
  def recibeCarta(card: Carta): Unit
}
