package cl.uchile.dcc
package gwent

import munit.FunSuite
import cl.uchile.dcc.gwent.cartas.clases.CombateDistancia
class CombateDistanciaTest extends FunSuite {
  val nombre1 = "Artis"
  val descripcion1 = "Cada vez que se juegue una unidad, le inflige un daño igual a la mitad de su poder."
  val poder1 = 5
  val distancia1 = new CombateDistancia(nombre1,descripcion1,poder1)
  test("Toda carta debe poseer un nombre, descripcion y poder"){
    assertEquals(distancia1.nombre, nombre1)
    assertEquals(distancia1.descripcion,descripcion1 )
    assertEquals(distancia1.poder, poder1)
  }
  test("Dos cartas con el mismo nombre deben ser la misma Carta"){

  }

}
