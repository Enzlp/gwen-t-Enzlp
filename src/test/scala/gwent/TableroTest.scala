package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.Jugador

class TableroTest extends FunSuite{

  test("Un tablero personal al inicio debe poseer zona de combate cuerpo a cuerpo vacía") {

  }
  test("Un tablero personal al inicio debe poseer zona de combate a distancia vacía") {

  }
  test("Un tablero personal al inicio debe poseer zona de combate de asedio vacía") {

  }
  test("Jugar una carta de clima implica que se encuentre en la zona de Clima"){

  }
  test("Jugar una carta de unidad implica que se encuentre en su zona de unidad respectiva") {

  }
  test("Ambos jugadores pueden jugar en el tablero de Clima, " +
    "y solo puede haber una carta de clima a la vez,y debe ser la ultima"){

  }
}
