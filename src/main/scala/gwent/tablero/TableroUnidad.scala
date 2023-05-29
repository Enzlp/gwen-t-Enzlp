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

  
  override def zonaCC: ArrayBuffer[Carta] = zCuerpoCuerpo
  override def zonaCA: ArrayBuffer[Carta] = zAsedio
  override def zonaCD: ArrayBuffer[Carta] = zDistancia


  override def recibeCartaCC(card: Carta): Unit = {
    zonaCC.addOne(card)
  }
  override def recibeCartaCA(card: Carta):Unit ={
    zonaCA.addOne(card)
  }

  override def recibeCartaCD(card: Carta): Unit = {
    zonaCD.addOne(card)
  }
}
