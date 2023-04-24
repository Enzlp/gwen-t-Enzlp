package cl.uchile.dcc
package gwent

import munit.FunSuite
import cl.uchile.dcc.gwent.Carta

class CartaTest extends FunSuite {
  val carta = new Carta("Clima Despejado")
  test("Las cartas deben tener nombre") {
    assertEquals(carta.nombre, "Clima Despejado")
  }
}
