package cl.uchile.dcc
package gwent.estados

import gwent.cartas.Carta
import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.estados.Player1TurnState
class Player2TurnState(controller: GameController) extends GameState(controller){
  override def playCard(card: Carta): Unit = {
    controller.setState(new Player1TurnState(controller))
  }

  override def passTurn(): Unit = {
    controller.setState(new Player1TurnState(controller))
  }

  override def onlyPlayerLeft(): Unit = {
    controller.setState(new Player2TurnState(controller))
  }

  override def endRound(): Unit = {
    controller.setState(new RoundEnd(controller))
  }
}
