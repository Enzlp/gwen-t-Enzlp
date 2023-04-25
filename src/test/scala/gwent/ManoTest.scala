package cl.uchile.dcc
package gwent
import munit.FunSuite
class ManoTest extends FunSuite {
  var mano = new Mano
  val card = new Carta("Escarcha mordiente")
  mano.add(card)
  var primer = mano.get(0)
  test("La funcion add de mano debe agregar cartas a la mano del jugador"){
    assertEquals(primer, card)
  }
}
