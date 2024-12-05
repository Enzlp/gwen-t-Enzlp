package cl.uchile.dcc
package gwent.testCartas

import munit.FunSuite
import gwent.cartas.clases.EscarchaMordiente
class EscarchaMordienteTest extends FunSuite {
  val nombre1 = "Escarcha Mordiente"
  val descripcion1 = "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1."
  val EM1 = new EscarchaMordiente(nombre1,descripcion1)
  test("Todas las cartas de Clima deben tener un nombre y descripcion"){
    assertEquals(EM1.nombre, nombre1)
    assertEquals(EM1.descripcion, descripcion1)
  }
}
