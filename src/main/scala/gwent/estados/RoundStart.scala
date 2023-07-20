package cl.uchile.dcc
package gwent.estados

/**Clase que representa el estado RoundStart
 * Este es el estado de inicio de ronda y se puede transicionar desde GameStart o RoundEnd. Como extiende
 * a Game State tiene un controlador asociado del tipo [[GameController]]
 * @param controller controlador asociado al estado
 */
class RoundStart(controller:GameController) extends GameState(controller){
  /**Método que transiciona al estado Player1TurnState
   * Este método es usado para iniciar una ronda del juego, para esto usa la función setState del controlador y 
   * establece el nuevo estado como Player1TurnState
   */
  override def startRound(): Unit = {
    controller.setState(new Player1TurnState(controller))
  }
}
