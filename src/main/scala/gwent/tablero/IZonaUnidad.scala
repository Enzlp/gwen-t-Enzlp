package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer
trait IZonaUnidad {
  /** Recibe una carta, y la inserta en el arreglo propio de la fila del jugador que jugó dicha carta*/
  def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit
  /** Método que retorna el arreglo con las cartas que están en la fila del jugador solicitado */
  def areaJuego(jugador: IJugador): ArrayBuffer[Carta]
}
