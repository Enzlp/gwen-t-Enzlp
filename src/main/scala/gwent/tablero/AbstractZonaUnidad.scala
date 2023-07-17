package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.tablero.IZonaUnidad

abstract class AbstractZonaUnidad(val owner1: IJugador, val owner2: IJugador) extends IZonaUnidad {
  private var _areaJuegoJugador1 = ArrayBuffer[Carta]()
  private var _areaJuegoJugador2 = ArrayBuffer[Carta]()
  override def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit = {
   jugador match
     case owner1 => _areaJuegoJugador1.addOne(card)
     case owner2 => _areaJuegoJugador2.addOne(card)
  }
  override def areaJuego(jugador: IJugador): ArrayBuffer[Carta] = {
    jugador match
      case owner1 => _areaJuegoJugador1
      case owner2 => _areaJuegoJugador2
  }

}
