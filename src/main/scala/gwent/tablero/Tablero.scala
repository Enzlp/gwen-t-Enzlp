package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITablero
import gwent.tablero.ZonaClima
import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.{ZonaCC, ZonaCA, ZonaCD}

class Tablero(private val jugador1: IJugador, private val jugador2: IJugador) extends ITablero{
  private var _zClima = new ZonaClima
  private var _zCombateCA1 = new ZonaCA(jugador1)
  private var _zCombateCA2 = new ZonaCA(jugador2)
  private var _zCombateCC1 = new ZonaCC(jugador1)
  private var _zCombateCC2 = new ZonaCC(jugador2)
  private var _zCombateCD1 = new ZonaCD(jugador1)
  private var _zCombateCD2 = new ZonaCD(jugador2)
  override def jugarCartaClima(card: Carta): Unit = {
    _zClima.recibeCartaClima(card)
  }
  override def jugarCartaCA(card: Carta, jugador: IJugador): Unit = {
    _zCombateCA1.recibeCartaUnidad(card, jugador)
    _zCombateCA2.recibeCartaUnidad(card, jugador)
  }
  override def jugarCartaCC(card: Carta, jugador: IJugador): Unit = {
    _zCombateCC1.recibeCartaUnidad(card, jugador)
    _zCombateCC2.recibeCartaUnidad(card, jugador)
  }
  override def jugarCartaCD(card: Carta, jugador: IJugador): Unit = {
    _zCombateCD1.recibeCartaUnidad(card, jugador)
    _zCombateCD2.recibeCartaUnidad(card, jugador)
  }
}
