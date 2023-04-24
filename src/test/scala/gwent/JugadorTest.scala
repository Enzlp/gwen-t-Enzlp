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
  test("Cartas en la mano tiene que ser menor que 10 y mayor o igual que cero") {
    assert(player.mano >= 0)
    assert(player.mano < 10)
  }
  test("El mazo de cartas no puede tener menos de cero cartas") {
    assert(player.mazo > 0)
  }
}
