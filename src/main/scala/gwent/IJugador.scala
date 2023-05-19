package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.ICarta

import scala.collection.mutable.ArrayBuffer

trait IJugador {
  def mostrarMano(): ArrayBuffer[ICarta]
  
  def robar(): Any

  def generarMazo(): Any

  def LLenarMano(): Any


}
