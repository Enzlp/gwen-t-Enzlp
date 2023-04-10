package cl.uchile.dcc
package Gwent

import munit.FunSuite

class PlayerTest extends FunSuite{
  val player = new Jugador("Alejandro")
  test("Jugadores deben poseer nombre"){
    assertEquals(player.nombre, "Alejandro")
  }
  test("Contador de Gemas tiene que ser igual o mayor a 0"){
    assert(player.gemas>=0)
  }
  test("Cartas en la mano tiene que ser menor que 10 y mayor o igual que cero"){
    assert(player.cartas >=0)
    assert(player.cartas <10)
  }
  test("El mazo de cartas no puede tener menos de cero cartas"){
    assert(player.mazo>0)
  }

}
