package cl.uchile.dcc
package gwent.estados

import munit.FunSuite
import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.estados.Player1TurnState
import cl.uchile.dcc.gwent.estados.RoundEnd
import cl.uchile.dcc.gwent.estados.RoundStart
import cl.uchile.dcc.gwent.jugadores.Jugador
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
class EstadosTest extends FunSuite{
  private var gameController = new GameController
  var arrayVacio: ArrayBuffer[Carta] = ArrayBuffer()
  val jugador1 = new Jugador("",2,arrayVacio,arrayVacio )
  val jugador2 = new Jugador("",2,arrayVacio,arrayVacio )

  test("El controlador debe partir en el estado GameStart"){
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[GameStart])
  }
  test("Transición desde GameStart a RoundStart"){
    gameController.startGame()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[RoundStart])
  }
  test("Transición desde RoundStart a Player1TurnState al comenzar la ronda"){
    gameController.startRound()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player1TurnState])
  }
  test("Transición desde Player1TurnState a Player2State al jugar una carta"){
    gameController.playCard()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player2TurnState])
  }
  test("Transición desde Player2TurnState a Player1State al jugar una carta"){
    gameController.playCard()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player1TurnState])
  }
  test("Transición desde Player1TurnState a si mismo cuando el jugador 2 paso el turno"){
    gameController.onlyPlayerLeft()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player1TurnState])
  }
  test("Transición desde Player1TurnState a Player2TurnState al pasar el turno"){
    gameController.addPlayer(jugador1)
    gameController.passTurn(jugador1)
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player2TurnState])
  }
  test("Transición desde Player2TurnState a si mismo cuando el jugador 2 paso el turno") {
    gameController.onlyPlayerLeft()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player2TurnState])
  }
  test("Transición desde Player2TurnState a Player1TurnState al pasar el turno") {
    gameController.passTurn(jugador1)
    gameController.passTurn(jugador1)
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[Player1TurnState])
  }
  test("Transición de Player1Turn a RoundEnd al pasar ambos jugadores de turno"){
    gameController.endRound()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[RoundEnd])
  }
  test("Transición de Player2Turn a RoundEnd al pasar ambos jugadores de turno") {
    gameController.masterSetState("126$", new Player2TurnState(gameController))
    gameController.endRound()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[RoundEnd])
  }
  test("Transición de RoundEnd a StartRound cuando todavía quedan gemas"){
    gameController.stillGems()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[RoundStart])
  }
  test("Transición de RoundEnd a GameEnd cuando no quedan gemas"){
    gameController.masterSetState("126$", new RoundEnd(gameController))
    gameController.noGems()
    val estado = gameController.estadoActual
    assert(estado.isInstanceOf[GameEnd])
  }

}
