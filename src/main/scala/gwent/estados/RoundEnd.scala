package cl.uchile.dcc
package gwent.estados

/**Clase que representa el estado RoundEnd
 * Cuando se termina la ronda debido a que ambos jugadores pasaran le turno si transiciona a este estado. Como extiende
 * a Game State tiene un controlador asociado del tipo [[GameController]]
 * @param controller controlador asociado al estado
 */
class RoundEnd(controller: GameController) extends GameState(controller){
  /**Método que transiciona al estado Roundstart
   * Este método es usado cuando todavía no ha habido un ganador del juego, y usa el método setState para establecer el
   * estado nuevo RoundStart y uqe parta de nuevo la ronda
   */
  override def stillGems(): Unit = {
    controller.setState(new RoundStart(controller))
  }
}
