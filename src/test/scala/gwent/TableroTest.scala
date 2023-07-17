package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.Jugador
import cl.uchile.dcc.gwent.cartas.clases.{CombateCuerpoCuerpo, CombateDistancia, CombateAsedio}
import cl.uchile.dcc.gwent.tablero.Tablero

class TableroTest extends FunSuite{
  val CC = new CombateCuerpoCuerpo("", "",5)
  val CoD = new CombateDistancia("","",5)
  val CA = new CombateAsedio("","",5)
  val LT = new LluviaTorrencial("","")
  val EM = new EscarchaMordiente("","")
  val NI = new NieblaImpenetrable("","")
  val ClD = new ClimaDespejado("","")
  var mano1: ArrayBuffer[Carta] = ArrayBuffer(CC, CoD, CA ,LT, EM, NI, ClD)
  var mano2: ArrayBuffer[Carta] = ArrayBuffer(CC, CoD, CA, ClD)
  var arrayVacio: ArrayBuffer[Carta] = ArrayBuffer()
  val jugador1 = new Jugador("Jugador1", 2, mano1, arrayVacio)
  val jugador2 = new Jugador("Jugador2", 2, mano2, arrayVacio)
  var board = new Tablero(jugador1, jugador2)
  test("Un tablero al inicio debe poseer zona de combate cuerpo a cuerpo vacía") {
    val x = board.mostrarZonaClimate
    assertEquals(x, arrayVacio)
  }
  test("Un tablero al inicio debe poseer zona de combate a distancia vacía") {
    val x = board.mostrarZonaCD(jugador1)
    val y = board.mostrarZonaCD(jugador2)
    assertEquals(x, arrayVacio)
    assertEquals(y, arrayVacio)
  }
  test("Un tablero al inicio debe poseer zona de combate de asedio vacía") {
    val x = board.mostrarZonaCA(jugador1)
    val y = board.mostrarZonaCA(jugador2)
    assertEquals(x, arrayVacio)
    assertEquals(y, arrayVacio)
  }
  test("Un tablero al inicio debe poseer zona de clima vacía"){
    val x = board.mostrarZonaClimate
    assertEquals(x, arrayVacio)
  }
  test("Jugar una carta de clima implica que se encuentre en la zona de Clima, y solo puede haber una la vez"){
    jugador1.jugarCarta(6, board)
    val a = board.mostrarZonaClimate(0)
    assertEquals(a, ClD)
    jugador1.jugarCarta(5, board)
    val b = board.mostrarZonaClimate(0)
    assertEquals(b, NI)
    jugador1.jugarCarta(4, board)
    val c = board.mostrarZonaClimate(0)
    assertEquals(c, EM)
    jugador1.jugarCarta(3, board)
    val d = board.mostrarZonaClimate(0)
    assertEquals(d, LT)
  }

  test("Ambos jugadores pueden jugar en el tablero de Clima, " +
    "y solo puede haber una carta de clima a la vez,y debe ser la ultima"){
    jugador2.jugarCarta(3,board)
    val x = board.mostrarZonaClimate(0)
    assertEquals(x, ClD)
  }
  test("Jugar una carta de unidad implica que se encuentre en su zona de unidad respectiva") {
    jugador1.jugarCarta(2, board)
    jugador1.jugarCarta(1, board)
    jugador1.jugarCarta(0, board)
    jugador2.jugarCarta(2, board)
    jugador2.jugarCarta(1, board)
    jugador2.jugarCarta(0, board)
    assertEquals(board.mostrarZonaCA(jugador1)(0), CA)
    assertEquals(board.mostrarZonaCC(jugador1)(0), CC)
    assertEquals(board.mostrarZonaCD(jugador1)(0), CoD)
    assertEquals(board.mostrarZonaCA(jugador2)(0), CA)
    assertEquals(board.mostrarZonaCC(jugador2)(0), CC)
    assertEquals(board.mostrarZonaCD(jugador2)(0), CoD)
  }
}
