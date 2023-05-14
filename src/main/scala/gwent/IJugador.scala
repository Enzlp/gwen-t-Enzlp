package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer

import gwent.ICarta
trait IJugador {
  def mostrarMano(): ArrayBuffer[ICarta]
  def robar(): Any

  def GenerarMazo(): Any

  def LLenarMano(): Any


}
