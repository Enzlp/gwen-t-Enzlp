package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.Carta

import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

import scala.collection.mutable.ArrayBuffer

/**Trait (interfaz) representa al tipo Tablero
 * En este trait se declaran 8 métodos que se implementarán en las clases que implementen este Trait.
 */
trait ITableroUnidad {
  /**
   * Recibe una [[Carta]] del tipo [[CombateCuerpoCuerpo]] para posicionarla en la zona de Combate cuerpo a cuerpo.
   * @param card:Carta a recibir para luego ser jugada en el tablero.
   */
  def recibeCartaCC(card: CombateCuerpoCuerpo): Unit

  /**
   * Recibe una [[Carta]] del tipo [[CombateDistancia]] para posicionarla en la zona de Combate a distancia.
   * @param card: Carta a recibir para luego ser jugada en el tablero.
   */
  def recibeCartaCD(card: CombateDistancia): Unit

  /**
   * Recibe una [[Carta]] del tipo [[CombateAsedio]] para posicionarla en la zona de Combate de Asedio.
   * @param card: Carta a recibir para luego ser jugada en el tablero.
   */

  def recibeCartaCA(card: CombateAsedio): Unit
  
  /**
   * Metodo para acceder a la zona de Combate Cuerpo a Cuerpo del tablero
   *
   * @return Un array con las cartas de Combate Cuerpo a Cuerpo en el tablero
   */
  def zonaCC: ArrayBuffer[Carta]

  /**
   * Metodo para acceder a la zona de Combate de Asedio del tablero
   *
   * @return Un array con las cartas de Combate de Asedio en el tablero
   */
  def zonaCA: ArrayBuffer[Carta]

  /**
   * Metodo para acceder a la zona de Combate a distancia del tablero
   *
   * @return Un array con las cartas de Combate a distancia en el tablero
   */
  def zonaCD: ArrayBuffer[Carta]


}
