package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.jugadores.IJugador

import scala.collection.mutable.ArrayBuffer
class ZonaClima extends IZonaClima {
  private var _areaJuego = ArrayBuffer[Carta]()
  override def recibeCartaClima(card: Carta): Unit = {
    _areaJuego.clear()
    _areaJuego.addOne(card)
  }

  override def areaJuego: ArrayBuffer[Carta] ={
    val x = _areaJuego
    x
  }
}
