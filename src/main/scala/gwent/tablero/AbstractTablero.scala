package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITablero
import gwent.cartas.Carta

import scala.collection.mutable.ArrayBuffer

abstract class AbstractTablero extends ITablero {
  private var zCuerpoCuerpo: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  private var zDistancia: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  private var zAsedio: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  private var zClima: ArrayBuffer[Carta] = ArrayBuffer[Carta]()

  override def zonaClima: ArrayBuffer[Carta] = zClima
  override def zonaCC: ArrayBuffer[Carta] = zCuerpoCuerpo
  override def zonaCA: ArrayBuffer[Carta] = zAsedio
  override def zonaCD: ArrayBuffer[Carta] = zDistancia

}
