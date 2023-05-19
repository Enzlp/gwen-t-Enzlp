package cl.uchile.dcc
package gwent.cartas


import munit.FunSuite


class AbstractCartaTest extends FunSuite {
  val carta = new AbstractCartaClima("Clima Despejado")
  val carta2 = new AbstractCartaUnidad("Unidad")
  test("Las cartas deben tener nombre") {
    assertEquals(carta.nombre, "Clima Despejado")
    assertEquals(carta2.nombre, "Unidad")
  }
  

}
