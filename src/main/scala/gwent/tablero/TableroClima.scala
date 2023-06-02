package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.{Carta}
import gwent.tablero.ITableroClima
import scala.collection.mutable.ArrayBuffer
class TableroClima extends ITableroClima {
  /** Variable privada que contiene el array con las carta actual en la zona de clima
   */
  private val _zonaClima: ArrayBuffer[Carta] = ArrayBuffer()

  /**Método de acceso de la zona de clima del tablero
   * @return el array con la carta que esta actualmente en la zona de Clima
   */
  override def zonaClima: ArrayBuffer[Carta] = _zonaClima

  /**Método que recibe la carta para luego posicionarla en la zona de clima
   * @param card: Carta que será posicionada en la zona de Clima
   */
  override def recibeCarta(card: Carta): Unit = {
    zonaClima.clear()
    zonaClima.addOne(card)
  }

}
