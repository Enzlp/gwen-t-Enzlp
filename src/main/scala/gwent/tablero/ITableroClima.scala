package cl.uchile.dcc
package gwent.tablero

import scala.collection.mutable.ArrayBuffer
import gwent.cartas.Carta
trait ITableroClima {
  def zonaClima: ArrayBuffer[Carta]
  def recibeCarta(card: Carta): Unit
}
