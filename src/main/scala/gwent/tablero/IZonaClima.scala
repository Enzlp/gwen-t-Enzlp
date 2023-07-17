package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.Carta

import cl.uchile.dcc.gwent.jugadores.IJugador

import scala.collection.mutable.ArrayBuffer

trait IZonaClima {
  def recibeCartaClima(card: Carta): Unit
  def areaJuego: ArrayBuffer[Carta]
}
