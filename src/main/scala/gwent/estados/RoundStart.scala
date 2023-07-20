package cl.uchile.dcc
package gwent.estados

class RoundStart(controller:GameController) extends GameState(controller){
  
  override def startRound(): Unit = {
    controller.setState(new Player1TurnState(controller))
  }
}
