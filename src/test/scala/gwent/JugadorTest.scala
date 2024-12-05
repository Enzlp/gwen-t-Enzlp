package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.Carta
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente}
import cl.uchile.dcc.gwent.tablero.Tablero
class JugadorTest extends FunSuite {
  val card1 = new ClimaDespejado("Clima Despejado", "Descripcion")
  val card2 = new CombateDistancia("Combate a Distancia", "Descripcion", 5)
  val mano1 = ArrayBuffer[Carta](card1, card2)
  val mazo1 = ArrayBuffer[Carta](card1,card2)
  val player = new Jugador("Alejandro", 2, mano1, mazo1)
  
  test("Jugadores deben poseer nombre") {
    assertEquals(player.nombre, "Alejandro")
  }

  test("Jugadores deben tener contador de Gemas, y este tiene que ser igual o mayor a 0") {
    assert(player.gemas >= 0)
  }
  test("Un Jugador debe poseer mano"){
    assertEquals(player.mano, mano1)
  }
  test("Un Jugador debe tener mazo"){
    assertEquals(player.mazo, mazo1)
  }
 
  test("Un jugador puede robar un carta del mazo"){
    player.robarCarta()
    val mano = ArrayBuffer[Carta](card1, card2, card2)
    assertEquals(player.mano, mano)
  }

}
