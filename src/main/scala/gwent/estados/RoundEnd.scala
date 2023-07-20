package cl.uchile.dcc
package gwent.estados

class RoundEnd(controller: GameController) extends GameState(controller){
  

  
  override def stillGems(): Unit = {
    controller.setState(new RoundStart(controller))
  }
}
