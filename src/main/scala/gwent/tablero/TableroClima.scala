package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.{Carta}
import gwent.tablero.ITableroClima
import scala.collection.mutable.ArrayBuffer
class TableroClima extends ITableroClima {
  private val zClima: ArrayBuffer[Carta] = ArrayBuffer()
  override def zonaClima: ArrayBuffer[Carta] = zClima
  override def recibeCarta(card: Carta): Unit = {
    zonaClima.clear()
    zonaClima.addOne(card)
  }

}
