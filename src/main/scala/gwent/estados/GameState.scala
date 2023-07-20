package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.excepciones.InvalidTransitionException
import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer
class GameState(var controller: GameController){
  
  def setController(controller: GameController): Unit ={
    this.controller = controller
  }
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
