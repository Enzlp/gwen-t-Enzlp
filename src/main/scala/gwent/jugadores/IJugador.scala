package cl.uchile.dcc
package gwent.jugadores

import gwent.cartas.Carta
import gwent.tablero.ITableroUnidad

import scala.collection.mutable.ArrayBuffer

/**Trait (interfaz) que representa un Jugador en Gwent
 * Posee 6 declaraciones de métodos: mano, mazo, robarCarta(), shuffleMazo(), jugarCarta(indice: Int) y personalBoard
 * Estos métodos se implementarán en las clases que implementen el trait o hereden el método.
 */
trait IJugador {
  /** Método de acceso a la mano del jugador
   */
  def mano: ArrayBuffer[Carta]

  /** Método de acceso al mazo del Jugador
   */
  def mazo: ArrayBuffer[Carta]

  /**Roba carta del mazo del Jugador
   * @return Carta que fue robada del mazo
   */
  def robarCarta(): Carta

  /**Revuelve el mazo del Jugador
   */
  def shuffleMazo(): Unit

  /** Juega Carta en un indice de la mano, en el tablero
   */
  def jugarCarta(indice: Int): Unit

  /**Método para acceder a el tablero del jugador
   */
  def personalBoard: ITableroUnidad
  
  /**Método de Acceso a la variable gemas
   */
  def gemas: Int

}
