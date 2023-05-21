package cl.uchile.dcc
package gwent.cartas


abstract class AbstractUnidad(nombre: String, descripcion: String, val poder: Int) extends AbstractCarta(nombre, descripcion) {
  var poderActual: Int = poder
}
