package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import cl.uchile.dcc.gwent.tablero.ZonaClima
import cl.uchile.dcc.gwent.jugadores.IJugador

trait ITablero {
  def jugarCartaClima(card: Carta): Unit
  def jugarCartaCA(card: Carta, jugador: IJugador):Unit
  def jugarCartaCD(card: Carta, jugador: IJugador):Unit
  def jugarCartaCC(card: Carta, jugador: IJugador):Unit
}