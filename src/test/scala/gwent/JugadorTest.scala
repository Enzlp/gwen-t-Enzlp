package cl.uchile.dcc
package gwent

import munit.FunSuite

class JugadorTest extends FunSuite {
  val player = new Jugador("Alejandro", 2)
  test("Jugadores deben poseer nombre") {
    assertEquals(player.nombre, "Alejandro")
  }
  test("Contador de Gemas tiene que ser igual o mayor a 0") {
    assert(player.gemas >= 0)
  }
}
