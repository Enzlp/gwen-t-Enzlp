package cl.uchile.dcc
package gwent.cartas

import cl.uchile.dcc.gwent.Carta
import munit.FunSuite


class CartaTest extends FunSuite {
  val carta = new Carta("Clima Despejado")
  val carta2 = new Carta("Niebla impenetrable")
  test("Las cartas deben tener nombre") {
    assertEquals(carta.nombre, "Clima Despejado")
  }

}
