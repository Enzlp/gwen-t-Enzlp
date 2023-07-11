package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.tablero.AbstractZonaUnidad
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.tablero.AbstractZona

abstract class AbstractZonaUnidad(val owner: IJugador) extends AbstractZona {
  override def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit = {
    if (jugador == owner) {
      areaJuego.addOne(card)
    }
  }
}
