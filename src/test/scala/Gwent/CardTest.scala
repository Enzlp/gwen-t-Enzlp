package cl.uchile.dcc
package Gwent

import munit.FunSuite
class CardTest extends FunSuite{
  val carta = new card("Clima Despejado")
  test("Las cartas deben tener nombre"){
    assertEquals(carta.nombre, "Clima Despejado")
    
  }

}
