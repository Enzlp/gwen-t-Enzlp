package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.Jugador
import cl.uchile.dcc.gwent.tablero.{TableroClima, TableroUnidad}
class TableroTest extends FunSuite{
  /**Definimos parametros para poder generar casos de prueba
   */
  val zonaVacia:ArrayBuffer[Carta] = ArrayBuffer()
  val gemas = 2
  val nombre = "Jugador"
  val nombreCarta = "Nombre Carta"
  val descripcion = "Descripcion"

  val card1 = new ClimaDespejado(nombreCarta, descripcion)
  val card2 = new EscarchaMordiente(nombreCarta, descripcion)
  val card3 = new LluviaTorrencial(nombreCarta, descripcion)
  val card4 = new NieblaImpenetrable(nombreCarta, descripcion)
  val card5 = new CombateAsedio(nombreCarta, descripcion, 5)
  val card6 = new CombateDistancia(nombreCarta, descripcion, 5)
  val card7 = new CombateCuerpoCuerpo(nombreCarta, descripcion, 5)

  val mano1: ArrayBuffer[Carta] = ArrayBuffer()
  val mano2: ArrayBuffer[Carta] = ArrayBuffer()

  val mazo1: ArrayBuffer[Carta] = ArrayBuffer(card1, card1)
  val mazo2: ArrayBuffer[Carta] = ArrayBuffer(card7, card6, card5, card2)

  val tableroClima1 = new TableroClima

  val player1 = new Jugador(nombre, gemas, mano1, mazo1, tableroClima1)
  val player2 = new Jugador(nombre, gemas, mano2, mazo2, tableroClima1)
  test("Un tablero personal al inicio debe poseer zona de combate cuerpo a cuerpo vacia") {
    assertEquals(player1.personalBoard.zonaCC, zonaVacia)
  }
  test("Un tablero personal al inicio debe poseer zona de combate a distancia vacia") {
    assertEquals(player1.personalBoard.zonaCD, zonaVacia)
  }
  test("Un tablero personal al inicio debe poseer zona de combate de asedio vacia") {
    assertEquals(player1.personalBoard.zonaCA, zonaVacia)
  }
  test("Jugar una carta de clima implica que se encuentre en la zona de Clima"){
    player1.robarCarta()
    player1.jugarCarta(0)
    assertEquals(tableroClima1.zonaClima(0), card1)
  }
  test("Jugar una carta de unidad implica que se encuentre en su zona de unidad respectiva") {
    player2.robarCarta()
    player2.robarCarta()
    player2.robarCarta()
    player2.jugarCarta(0)
    assertEquals(player2.personalBoard.zonaCC(0), card7)
    player2.jugarCarta(0)
    assertEquals(player2.personalBoard.zonaCD(0), card6)
    player2.jugarCarta(0)
    assertEquals(player2.personalBoard.zonaCA(0), card5)
  }
  test("Ambos jugadores pueden jugar en el tablero de Clima, " +
    "y solo puede haber una carta de clima a la vez,y debe ser la ultima"){
    player1.robarCarta()
    player2.robarCarta()
    player1.jugarCarta(0)
    assertEquals(tableroClima1.zonaClima(0), card1)
    player2.jugarCarta(0)
    assertEquals(tableroClima1.zonaClima(0), card2)
  }
}
