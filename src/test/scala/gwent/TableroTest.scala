package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.tablero.Tablero
class TableroTest extends FunSuite{
  /**Definimos parametros para poder generar casos de prueba
   */
  val tablero1 = new Tablero()
  val zonaVacia: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  val nombre = "Alejandro"
  val gemas = 2
  val card1 = new ClimaDespejado("Clima Despejado", "Descripcion")
  val card2 = new CombateDistancia("Combate a Distancia", "Descripcion", 5)
  val card3 = new CombateCuerpoCuerpo("Combate Cuerpo a Cuerpo", "Descripcion", 5)
  val card4 = new CombateAsedio("Combate Asedio", "Descripcion", 5)
  val card5 = new EscarchaMordiente("Escarcha Mordiente", "Descripcion")
  val mano: ArrayBuffer[Carta] = ArrayBuffer[Carta](card1,card2, card3, card4)
  val mazo: ArrayBuffer[Carta] = ArrayBuffer[Carta]()
  val player = new Jugador(nombre, gemas, mano, mazo)
  val mano2: ArrayBuffer[Carta] = ArrayBuffer[Carta](card1,card5)
  val player2 = new Jugador(nombre, gemas, mano2,mazo)
  test("Un tablero al inicio debe poseer zona de clima vacia"){
    assertEquals(tablero1.zonaClima, zonaVacia)
  }
  test("Un tablero al inicio debe poseer zona de combate cuerpo a cuerpo vacia") {
    assertEquals(tablero1.zonaCC, zonaVacia)
  }
  test("Un tablero al inicio debe poseer zona de combate a distancia vacia") {
    assertEquals(tablero1.zonaCD, zonaVacia)
  }
  test("Un tablero al inicio debe poseer zona de combate de asedio vacia") {
    assertEquals(tablero1.zonaCA, zonaVacia)
  }
  test("Jugar una carta de clima implica que se encuentre en la zona de Clima"){
    player.jugarCarta(0)
    assertEquals(player.personalBoard.zonaClima(0), card1)
  }
  test("Jugar una carta de unidad implica que se encuntre en su zona de unidad respectiva") {
    player.jugarCarta(0)
    assertEquals(player.personalBoard.zonaCD(0), card2)
    player.jugarCarta(0)
    assertEquals(player.personalBoard.zonaCC(0), card3)
    player.jugarCarta(0)
    assertEquals(player.personalBoard.zonaCA(0), card4)
  }
  test("Solo puede haber una carta de clima a la vez"){
    player2.jugarCarta(0)
    player2.jugarCarta(0)
    assertEquals(player2.personalBoard.zonaClima(0), card5)
    assertEquals(player2.personalBoard.zonaClima.knownSize, 1)
  }
}
