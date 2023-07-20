package cl.uchile.dcc
package gwent.observers

import gwent.jugadores.Jugador

import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.cartas.clases.CombateCuerpoCuerpo
import cl.uchile.dcc.gwent.estados.{GameController, GameEnd}
import cl.uchile.dcc.gwent.gemObserver.Loser

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.estados.GameEnd
class SubjectTest extends munit.FunSuite {
  var arrayVacio: ArrayBuffer[Carta] = ArrayBuffer()
  val jugador1 = new Jugador("Jugador1", 2, arrayVacio, arrayVacio)
  val jugador2 = new Jugador("Jugador2", 2, arrayVacio, arrayVacio)
  val gameController = new GameController
  test("Función para agregar observadores"){
    jugador1.addObserver(gameController)
    assertEquals(jugador1.showObservers(0), gameController)
  }
  test("Notificar a los observadores desencadena el fin del juego"){
    jugador1.notifyObservers(Loser(jugador1.nombre))
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[GameEnd])
  }
}
