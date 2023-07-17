package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITablero
import gwent.tablero.ZonaClima

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.{ZonaCA, ZonaCC, ZonaCD}

import scala.collection.mutable.ArrayBuffer

class Tablero(private val jugador1: IJugador, private val jugador2: IJugador) extends ITablero{
  private var _zClima = new ZonaClima
  private var _zCombateCA = new ZonaCA(jugador1, jugador2)
  private var _zCombateCC = new ZonaCC(jugador1, jugador2)
  private var _zCombateCD = new ZonaCD(jugador1, jugador2)

  override def jugarCartaClima(card: Carta): Unit = {
    _zClima.recibeCartaClima(card)
  }
  override def jugarCartaCA(card: Carta, jugador: IJugador): Unit = {
    _zCombateCA.recibeCartaUnidad(card, jugador)
  }
  override def jugarCartaCC(card: Carta, jugador: IJugador): Unit = {
    _zCombateCC.recibeCartaUnidad(card, jugador)
  }
  override def jugarCartaCD(card: Carta, jugador: IJugador): Unit = {
    _zCombateCD.recibeCartaUnidad(card, jugador)
  }
  override def mostrarZonaClimate: ArrayBuffer[Carta] = {
    val z = _zClima.areaJuego
    z
  }
  override def mostrarZonaCA(jugador: IJugador): ArrayBuffer[Carta] = {
    val z = _zCombateCA.areaJuego(jugador)
    z
  }
  override def mostrarZonaCC(jugador: IJugador): ArrayBuffer[Carta] = {
    val z = _zCombateCC.areaJuego(jugador)
    z
  }
  override def mostrarZonaCD(jugador: IJugador): ArrayBuffer[Carta] = {
    val z = _zCombateCD.areaJuego(jugador)
    z
  }
}
