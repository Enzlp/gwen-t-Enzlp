package cl.uchile.dcc
package gwent

import munit.FunSuite


class CartaTest extends FunSuite {
  val carta = new Carta("Clima Despejado")
  val carta2 = new Carta("Niebla impenetrable")
  test("Las cartas deben tener nombre") {
    assertEquals(carta.nombre, "Clima Despejado")
  }

}
