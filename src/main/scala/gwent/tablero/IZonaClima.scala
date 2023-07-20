package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.Carta

import cl.uchile.dcc.gwent.jugadores.IJugador

import scala.collection.mutable.ArrayBuffer

trait IZonaClima {
  /** Método que recibe una carta y la posiciona en el área de juego */
  def recibeCartaClima(card: Carta): Unit
  /** Método que retorna el arreglo con las cartas en el área de juego */
  def areaJuego: ArrayBuffer[Carta]
}
