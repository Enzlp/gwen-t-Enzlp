package cl.uchile.dcc
package gwent.testCartas

import gwent.cartas.clases.CombateCuerpoCuerpo

import munit.FunSuite

class CombateCCTest extends FunSuite {
  val nombre1 = "Keltullis"
  val descripcion1 = "Cada turno aliado, al final del turno, destruye la unidad inferior del lado con más unidades."
  val poder1 = 9
  val cc1 = new CombateCuerpoCuerpo(nombre1, descripcion1, poder1)

  test("Toda carta debe poseer un nombre, descripcion y poder"){
    assertEquals(cc1.nombre, nombre1)
    assertEquals(cc1.descripcion, descripcion1)
    assertEquals(cc1.poder, poder1)
  }
  test("El poder actual debe partir siendo el poder asignado a la carta"){
    assertEquals(cc1.poderActual, poder1)
    assertEquals(poder1, cc1.poderActual)
  }
}
