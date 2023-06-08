package cl.uchile.dcc
package gwent.controlador

import gwent.cartas.Carta

class GameState {
  def comienzoJuego(): Unit = {}
  def jugarCarta(card: Carta): Unit = {}
  def robarCarta(): Unit = {}
  def pasarTurno(): Unit = {}
  def terminoTurno(): Unit = {}
  def limpiarTablero():Unit={}
}
