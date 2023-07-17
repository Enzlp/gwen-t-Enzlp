package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer
trait IZonaUnidad {
  def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit
  def areaJuego(jugador: IJugador): ArrayBuffer[Carta]
}
