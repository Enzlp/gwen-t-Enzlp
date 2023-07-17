package cl.uchile.dcc
package gwent.estados
import munit.FunSuite
import cl.uchile.dcc.gwent.excepciones.InvalidTransitionException
class InvalidTransitionExceptionTest extends FunSuite {
  val gameController = new GameController
  val gameStart = new GameStart(gameController)
  val exception = new InvalidTransitionException("")
  
}
