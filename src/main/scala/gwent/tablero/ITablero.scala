package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import cl.uchile.dcc.gwent.tablero.ZonaClima
import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer

trait ITablero {
  /** Método de Acceso a la zona de clima */
  def mostrarZonaClimate: ArrayBuffer[Carta]
  /** Método de Acceso a la zona de combate cuerpo a cuerpo */
  def mostrarZonaCC(jugador: IJugador): ArrayBuffer[Carta]
  /** Método de Acceso a la zona de combate de Asedio */
  def mostrarZonaCA(jugador: IJugador): ArrayBuffer[Carta]
  /** Método de acceso a la zona de combate a distancia */
  def mostrarZonaCD(jugador: IJugador): ArrayBuffer[Carta]
  /** Método para jugar una carta de Clima en el tablero*/
  def jugarCartaClima(card: Carta): Unit
  /** Método para jugar una carta de Combate de Asedio en el tablero*/
  def jugarCartaCA(card: Carta, jugador: IJugador):Unit
  /** Método para jugar una carta de combate de distancia en el tablero*/
  def jugarCartaCD(card: Carta, jugador: IJugador):Unit
  /** Método para jugar una carta de combate cuerpo a cuerpo en el tablero*/
  def jugarCartaCC(card: Carta, jugador: IJugador):Unit

}
