package cl.uchile.dcc
package gwent.testCartas

import gwent.cartas.clases.ClimaDespejado
import munit.FunSuite
class ClimaDespejadoTest extends FunSuite{
  val nombre1 = "Clima Despejado"
  val descripcion1 = "Cada turno aliado, al final del turno, destruye la unidad inferior del lado con más unidades."
  val cartaClima1 = new ClimaDespejado(nombre1, descripcion1)
  test("Toda carta debe poseer un nombre y descripcion ") {
    assertEquals(cartaClima1.nombre, nombre1)
    assertEquals(cartaClima1.descripcion, descripcion1)
  }
}
