package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITablero
import gwent.cartas.Carta

import scala.collection.mutable.ArrayBuffer

/**Clase Abstracta que representa un tablero individual del jugador
 * La clase implementa zonas donde jugar cartas con Arrays.
 */
abstract class AbstractTablero extends ITablero {
  /** Las zonas donde se juegan las cartas en el tablero se identifican con Arrays.
   */
  private var zCuerpoCuerpo: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  private var zDistancia: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  private var zAsedio: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  private var zClima: ArrayBuffer[Carta] = ArrayBuffer[Carta]()

  override def zonaClima: ArrayBuffer[Carta] = zClima
  override def zonaCC: ArrayBuffer[Carta] = zCuerpoCuerpo
  override def zonaCA: ArrayBuffer[Carta] = zAsedio
  override def zonaCD: ArrayBuffer[Carta] = zDistancia

  override def recibeCartaClima(card: Carta):Unit = {
    zonaClima.clear()
    zonaClima.addOne(card)
  }

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
