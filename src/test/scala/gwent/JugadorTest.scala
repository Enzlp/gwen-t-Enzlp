package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.Carta
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente}
import cl.uchile.dcc.gwent.jugadores.Jugador
import cl.uchile.dcc.gwent.tablero.TableroClima
class JugadorTest extends FunSuite {
  val nombreCarta = "nombre_generico"
  val descripcion = "descripcion"
  val card1 = new ClimaDespejado(nombreCarta, descripcion)
  val card2 = new CombateDistancia(nombreCarta, descripcion, 5)
  val card3 = new CombateAsedio(nombreCarta, descripcion, 5)
  val card4 = new CombateCuerpoCuerpo(nombreCarta, descripcion, 5)
  val card5 = new EscarchaMordiente(nombreCarta, descripcion)

  val mano1 = ArrayBuffer[Carta]()
  val mano2 = ArrayBuffer[Carta]()

  val mazo1 = ArrayBuffer[Carta](card1,card2)
  val mazo2 = ArrayBuffer[Carta](card3, card4, card5)

  val tableroClima1 = new TableroClima

  val name = "Alejandro"
  val gemas = 2
  val player = new Jugador(name, gemas, mano1, mazo1, tableroClima1)
  val player2 = new Jugador(name, gemas, mano2, mazo2, tableroClima1)


  test("Jugadores deben poseer nombre") {
    assertEquals(player.nombre, name)
  }
  test("Un jugador debe tener gemas"){
    assertEquals(player.gemas, gemas)
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
 
  test("Un jugador puede robar un carta del mazo") {
    val carta = player.robarCarta()
    /** Vemos que al robar un carta esta queda en la mano del jugador
     */
    assertEquals(player.mano(0), card1)
    assertEquals(carta, card1)
    /** Vemos que en el mazo se elimina la carta robada
     */
    assertEquals(player.mazo.size, 1)
    assertEquals(player.mazo(0), card2)
  }
  test("Debe existir un método para revolver el mazo"){
    player2.shuffleMazo()
    /** Evaluamos si se puede conseguir un mazo diferente al usar la funcion shuffle,
     * con los mismos elementos y tamano
     */
    while(player2.mazo == mazo2){
      player2.shuffleMazo()
    }
    assertNotEquals(player2.mazo, mazo2)
    player2.mazo.sameElements(mazo2)
    assertEquals(player2.mazo.size, mazo2.size)
  }
}
