package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITableroUnidad
import gwent.cartas.Carta

import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

import scala.collection.mutable.ArrayBuffer

/**Clase que representa un tablero individual del jugador
 * La clase TableroUnidad es un tipo de [[ITableroUnidad]] que implementa zonas donde jugar cartas con Arrays.
 * @constructor: Crea un nuevo 'TableroUnidad'.
 */
class TableroUnidad extends ITableroUnidad {
  /** Las zonas donde se juegan las cartas en el tablero se identifican con Arrays.
   */
  private val _zonaCC: ArrayBuffer[Carta] = ArrayBuffer()
  private val _zonaCD: ArrayBuffer[Carta] = ArrayBuffer()
  private val _zonaCA: ArrayBuffer[Carta] = ArrayBuffer()

  /**Método de acceso a la zona de combate de cuerpo a cuerpo del tablero
   * Es un Getter
   *  @return Un array con las cartas de Combate Cuerpo a Cuerpo en el tablero
   */
  override def zonaCC: ArrayBuffer[Carta] = _zonaCC
  /**Método de acceso a la zona de combate de Asedio del tablero
   * Es nuestro Getter
   *  @return Un array con las cartas de Combate de Asedio en el tablero
   */
  override def zonaCA: ArrayBuffer[Carta] = _zonaCA
  /**Método de acceso a la zona de combate a distancia del tablero
   * Es nuestro Getter
   *  @return Un array con las cartas de Combate a distancia en el tablero
   */
  override def zonaCD: ArrayBuffer[Carta] = _zonaCD
  /**Método que recibe una carta de Cuerpo a Cuerpo, para luego posicionarla
   * en la zona de combate cuerpo a cuerpo
   * @param card:Carta a recibir para luego ser jugada en el tablero.
   */
  override def recibeCartaCC(card: CombateCuerpoCuerpo): Unit = {
    zonaCC.addOne(card)
  }
  /** Método que recibe una carta de Asedio, para luego posicionarla
   * en la zona de combate de asedio
   * @param card: Carta a recibir para luego ser jugada en el tablero.
   */
  override def recibeCartaCA(card: CombateAsedio):Unit ={
    zonaCA.addOne(card)
  }
  /** Método que recibe una carta de combate a Distancia, para luego posicionarla
   * en la zona de combate a distancia
   * @param card: Carta a recibir para luego ser jugada en el tablero.
   */
  override def recibeCartaCD(card: CombateDistancia): Unit = {
    zonaCD.addOne(card)
  }
}
