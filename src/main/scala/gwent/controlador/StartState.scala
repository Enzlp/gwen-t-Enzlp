package cl.uchile.dcc
package gwent.controlador

import gwent.controlador.GameState
import gwent.controlador.GameController

import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.Jugador
class StartState(controller: GameController) extends GameState {
  override def comienzoJuego(): Unit = {
    controller.state = new TurnoState
  }

  override def jugarCarta(card: Carta): Unit = {
    //controller.state = new
  }
  override def terminoTurno(): Unit = {
    //controller.state = new
  }

}
