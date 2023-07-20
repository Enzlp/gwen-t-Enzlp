package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.excepciones.InvalidTransitionException
import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer

/**Clase que representa un estado del controlador del juego
 *
 * Es parte del State pattern, define un esqueleto para los estados concretos que extenderán esta clase. Posee un método
 * para cambiar el controlador de el estado. Y las funciones que desencadenan el cambio de los estados en el controlador
 * están definidas para arrojar excepciones cuando haya una transición invalida
 * @param controller controlador asociado al estado
 */
class GameState(var controller: GameController){
  /**Método que cambia el controlador por uno dado
   * Este método recibe un controlador y lo establece como el controlador asociado a este estado
   * @param controller controlador nuevo al que se va a cambiar
   */
  def setController(controller: GameController): Unit ={
    this.controller = controller
  }

  /**Todos los siguientes son métodos de cambio de estado que están iniciados ára lanzar una excepcion de transición 
   * invalida entre estados, esto luego se cambiara con override en cada subclase*/
  def startGame(jugadores: ArrayBuffer[IJugador]) : Unit = {
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
  def startRound(): Unit ={
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
  def playCard(): Unit = {
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
  def passTurn(): Unit = {
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
  def onlyPlayerLeft(): Unit ={
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
  def noGems(): Unit ={
    controller.setState(new GameEnd(controller))
  }
  def stillGems(): Unit ={
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
  def endRound(): Unit ={
    throw new InvalidTransitionException("Transición invalida entre estados")
  }
}
