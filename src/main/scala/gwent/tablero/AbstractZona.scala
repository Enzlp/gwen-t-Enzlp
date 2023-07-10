package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.tablero.IZona
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.AbstractZona

import scala.collection.mutable.ArrayBuffer
abstract class AbstractZona extends IZona{
  private var _areaJuego: ArrayBuffer[Carta] = ArrayBuffer()
  override def areaJuego: ArrayBuffer[Carta] = _areaJuego
  override def recibeCartaClima(card: Carta): Unit ={}
  override def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit ={}
}

