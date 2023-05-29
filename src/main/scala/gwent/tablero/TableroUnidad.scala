package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITableroUnidad
import gwent.cartas.Carta

import scala.collection.mutable.ArrayBuffer

/**Clase Abstracta que representa un tablero individual del jugador
 * La clase implementa zonas donde jugar cartas con Arrays.
 */
class TableroUnidad extends ITableroUnidad {
  /** Las zonas donde se juegan las cartas en el tablero se identifican con Arrays.
   */
  private val zCuerpoCuerpo: ArrayBuffer[Carta] = ArrayBuffer()
  private val  zDistancia: ArrayBuffer[Carta] = ArrayBuffer()
  private val zAsedio: ArrayBuffer[Carta] = ArrayBuffer()

  /**Método de acceso a la zona de combate de cuerpo a cuerpo del tablero
   *  @return Un array con las cartas de Combate Cuerpo a Cuerpo en el tablero
   */
  override def zonaCC: ArrayBuffer[Carta] = zCuerpoCuerpo
  /**Método de acceso a la zona de combate de Asedio del tablero
   *  @return Un array con las cartas de Combate de Asedio en el tablero
   */
  override def zonaCA: ArrayBuffer[Carta] = zAsedio
  /**Método de acceso a la zona de combate a distancia del tablero
   *  @return Un array con las cartas de Combate a distancia en el tablero
   */
  override def zonaCD: ArrayBuffer[Carta] = zDistancia
  /**Método que recibe una carta de Cuerpo a Cuerpo, para luego posicionarla
   * en la zona de combate cuerpo a cuerpo
   * @param card:Carta a recibir para luego ser jugada en el tablero.
   */
  override def recibeCartaCC(card: Carta): Unit = {
    zonaCC.addOne(card)
  }
  /** Método que recibe una carta de Asedio, para luego posicionarla
   * en la zona de combate de asedio
   * @param card: Carta a recibir para luego ser jugada en el tablero.
   */
  override def recibeCartaCA(card: Carta):Unit ={
    zonaCA.addOne(card)
  }
  /** Método que recibe una carta de combate a Distancia, para luego posicionarla
   * en la zona de combate a distancia
   * @param card: Carta a recibir para luego ser jugada en el tablero.
   */
  override def recibeCartaCD(card: Carta): Unit = {
    zonaCD.addOne(card)
  }
}
