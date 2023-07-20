package cl.uchile.dcc
package gwent.testCartas

import munit.FunSuite
import gwent.cartas.clases.NieblaImpenetrable
class NieblaImpenetrableTest extends FunSuite{
  val nombre1 = "Niebla Impenetrable"
  val descripcion1 = "Descripcion"
  val NI1 = new NieblaImpenetrable(nombre1,descripcion1)
  test("Todas las cartas de Clima deben tener un nombre y descripcion"){
    assertEquals(NI1.nombre, nombre1)
    assertEquals(NI1.descripcion, descripcion1)
  }
}
