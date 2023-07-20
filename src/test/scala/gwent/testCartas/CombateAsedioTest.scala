package cl.uchile.dcc
package gwent.testCartas

import gwent.cartas.clases.CombateAsedio

import munit.FunSuite
class CombateAsedioTest extends FunSuite{
  val nombre1 = "El Canalla"
  val descripcion1 = "Invoca la primera unidad de bronce de la baraja de tu rival a la fila opuesta y luego coloca un botín en ella."
  val poder1 = 12
  val asedio1 = new CombateAsedio(nombre1, descripcion1, poder1, false, false)
  test("Toda carta debe poseer un nombre, descripcion y poder") {
    assertEquals(asedio1.nombre, nombre1)
    assertEquals(asedio1.descripcion, descripcion1)
    assertEquals(asedio1.poder, poder1)
  }
  test("el poder actual de una carta parte siendo el poder de la carta original") {
    assertEquals(asedio1.poderActual, poder1)
  }
  
}
