package cl.uchile.dcc
package gwent.cartas


import munit.FunSuite


class CartaTest extends FunSuite {
  val carta = new CartaClima("Clima Despejado")
  val carta2 = new CartaUnidad("Unidad")
  test("Las cartas deben tener nombre") {
    assertEquals(carta.nombre, "Clima Despejado")
    assertEquals(carta2.nombre, "Unidad")
  }
  

}
