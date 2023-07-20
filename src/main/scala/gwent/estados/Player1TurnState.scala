package cl.uchile.dcc
package gwent.estados
import gwent.cartas.Carta

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.estados.Player2TurnState

/**Clase que representa el estado Player1TurnState
 * Este estado respresenta el turno del primer jugador.
 * @param controller controlador asociado al estado
 */
class Player1TurnState(controller: GameController) extends GameState(controller){
  /**Método de jugar carta
   * Este método produce un cambio de estado cuando el jugador juega una carta, pasando al estado Player2TurnState
   */
  override def playCard(): Unit = {
    controller.setState(new Player2TurnState(controller))
  }

  /** Método de pasar el turno
   * Este método produce un cambio de estado cuando el jugador pasa el turno, pasando al estado Player2turnState
   */
  override def passTurn(): Unit ={
    controller.setState(new Player2TurnState(controller))
  }

  /** Método de transición cuando es el único jugador que no ha pasado el turno
   * Este método produce un cambio de estado cuando el otro jugador ya ha pasado el turno, pasando al estado 
   * Player1turnState de nuevo.
   */
  
  override def onlyPlayerLeft(): Unit = {
    controller.setState(new Player1TurnState(controller))
  }

  /**Método de transición cuando termina la ronda
   * Este método produce un cambio de estado al estado RoundEnd, este se invoca cuando ambos jugadores hayan pasado el 
   * turno
   */
  override def endRound(): Unit ={
    controller.setState(new RoundEnd(controller))
  }

}
