package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameState
import cl.uchile.dcc.gwent.estados.StartState
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.observer.Publisher
import cl.uchile.dcc.gwent.tablero.{ITablero, Tablero}

import scala.collection.mutable.ArrayBuffer
class GameController {
  private var state: GameState = new StartState(this)
  private var _jugadores: ArrayBuffer[IJugador] = ArrayBuffer()
  private var notificar: Publisher = new Publisher(this)
  def jugadores: ArrayBuffer[IJugador] = _jugadores
  def startGame(jugador1: IJugador, jugador2: IJugador): Unit ={
    _jugadores = _jugadores :+ jugador1
    _jugadores = _jugadores :+ jugador2
    notificar.addPlayer(jugador1)
    notificar.addPlayer(jugador2)
  }
  def noGems(): Unit ={
    state = new EndGame(this)
  }


}
