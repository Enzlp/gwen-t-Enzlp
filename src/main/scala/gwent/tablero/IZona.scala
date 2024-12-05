package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.Carta
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.jugadores.IJugador
trait IZona {
  def areaJuego: ArrayBuffer[Carta]
  def recibeCartaClima(card: Carta): Unit
  
  def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit
}
