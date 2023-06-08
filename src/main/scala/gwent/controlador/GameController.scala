package cl.uchile.dcc
package gwent.controlador

import gwent.cartas.Carta
import gwent.controlador.StartState
import scala.collection.mutable.ArrayBuffer
class GameController {
  var mazo_vacio_1: ArrayBuffer[Carta] = ArrayBuffer()
  var mazo_vacio_2: ArrayBuffer[Carta] = ArrayBuffer()
  var mano_vacia_1: ArrayBuffer[Carta] = ArrayBuffer()
  var mano_vacio_2: ArrayBuffer[Carta] = ArrayBuffer()
  var state: GameState = new StartState(this)
  def comienzoJuego(): Unit = {
    state.comienzoJuego()
  }
  def jugarCarta(card: Carta): Unit = {

  }
  def robarCarta():Unit = {
  }
  def pasarTurno(): Unit = {

  }
  def terminoTurno(): Unit ={
  }
  def limpiarTablero(): Unit ={

  }

}
