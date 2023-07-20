package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.jugadores.IJugador

import scala.collection.mutable.ArrayBuffer
class GameStart(controller: GameController) extends GameState(controller){
  

  override def startGame(jugadores: ArrayBuffer[IJugador]): Unit ={
    controller.setState(new RoundStart(controller))
  }
  

}
