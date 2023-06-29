package cl.uchile.dcc
package gwent.tablero2

import gwent.cartas.Carta
import scala.collection.mutable.ArrayBuffer
import gwent.jugadores.Jugador
class Tablero2(val jugador1: Jugador, val jugador2: Jugador) {
  private var _zonaClima: ArrayBuffer[Carta] = ArrayBuffer()
  private var tablero1 = new TableroUnidad2
  private var tablero2 = new TableroUnidad2


}
