package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.excepciones.InvalidTransitionException
import cl.uchile.dcc.gwent.jugadores.Jugador
import cl.uchile.dcc.gwent.cartas.Carta
import scala.collection.mutable.ArrayBuffer
import munit.FunSuite
class InvalidTransitionTest extends FunSuite{
  private var gameController = new GameController
  val password = "126$"
  val jugadorNUll = new Jugador("", 2, ArrayBuffer[Carta](), ArrayBuffer[Carta]())
  test("Transición invalida entre estados usando startRound"){
    var x: Int = 0
    try{
      gameController.startRound()
    }catch{
      case e: Exception => x+=1
    }
    assert(x == 1)
  }
  test("Transición invalida entre estados usando playCard") {
    var x: Int = 0
    try{
      gameController.playCard()
    }catch {
      case e: Exception => x+=1
    }
    assert(x == 1)
  }
  test("Transición invalida entre estados usando passTurn") {
    var x: Int = 0
    try {
      gameController.passTurn(jugadorNUll)
    } catch {
      case e: Exception => x += 1
    }
    assert(x == 1)
  }
  test("Transición invalida entre estados usando onlyPlayerLeft"){
    var x: Int = 0
    try{
      gameController.onlyPlayerLeft()
    } catch{
      case e: Exception => x+=1
    }
    assert(x ==1)
  }
  test("Transición invalida entre estados usando stillGems"){
    var x = 0
    try{
      gameController.stillGems()
    }catch{
      case e: Exception => x+=1
    }
    assert(x == 1)
  }
  test("Transición inválida entre estados usando endRound"){
    var x = 0
    try {
      gameController.endRound()
    } catch {
      case e: Exception => x += 1
    }
    assert(x == 1)
  }
  test("Transicion inválida entre estados usando startGame"){
    var x = 0
    gameController.masterSetState(password, new RoundStart(gameController))
    try{
      gameController.startGame()
    }catch{
      case e: Exception => x+=1
    }
    assert(x == 1)
  }
}
