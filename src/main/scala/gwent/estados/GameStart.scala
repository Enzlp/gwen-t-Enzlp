package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.jugadores.IJugador

import scala.collection.mutable.ArrayBuffer

/**Clase que representa el estado de partida del controlador
 *
 * Este el estado en el que parte el juego, se crea con un parámetro de controlador asociado
 * @param controller controlador asociado al estado
 */
class GameStart(controller: GameController) extends GameState(controller){
  /**Método que cambia el estado del controlador 'controller'
   * Este método transiciona el estado del controlador de GameStart a RoundStart
   * @param jugadores arreglo con los jugadores en juego
   */

  override def startGame(jugadores: ArrayBuffer[IJugador]): Unit ={
    controller.setState(new RoundStart(controller))
  }
  

}
