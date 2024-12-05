package cl.uchile.dcc
package gwent.testCartas

import munit.FunSuite
import gwent.cartas.clases.LluviaTorrencial
class LluviaTorrencialTest extends FunSuite {
  val nombre1 = "Lluvia Torrencial"
  val descripcion1 = "Establece el valor de todas las cartas de asedio a 1."
  val LT1 = new LluviaTorrencial(nombre1, descripcion1)
  test("Todas las cartas de Clima deben tener un nombre y descripcion"){
    assertEquals(LT1.nombre, nombre1)
    assertEquals(LT1.descripcion, descripcion1)
  }
}
