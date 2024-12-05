package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.cartas.Carta
class GameState(val controller: GameController){
  def startGame(): Unit = {
    /* ... */
  }

  def playCard(card: Carta): Unit = {
    /* ... */
  }

  def endTurn(): Unit = {
    /* ... */
  }

}
