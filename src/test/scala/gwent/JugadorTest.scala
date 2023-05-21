package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.Carta
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class JugadorTest extends FunSuite {
  val mano1 = ArrayBuffer[Carta]()
  val mazo1 = ArrayBuffer[Carta]()
  val player = new Jugador("Alejandro", 2, mano1, mazo1)
  val player2 = new Jugador("Alejandro", 2, mano1, mazo1)
  test("Jugadores deben poseer nombre") {
    assertEquals(player.nombre, "Alejandro")
  }

  test("Jugadores deben tener contador de Gemas, y este tiene que ser igual o mayor a 0") {
    assert(player.gemas >= 0)
  }
  test("Dos jugadores con el mismo nombre deben ser el mismo Jugador"){

  }

}
