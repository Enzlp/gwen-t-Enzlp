package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
class AbstractUnitEffects extends Visitor {
  protected var _cartaJugada: ArrayBuffer[Carta] = ArrayBuffer()
  def cartaJugada(card: Carta): Unit = {
    _cartaJugada.clear()
    _cartaJugada = _cartaJugada :+ card
  }
  override def visitCombateCA(ca: CombateAsedio): Unit = {/*...*/}
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {/*...*/}
  override def visitCombateCD(cd: CombateDistancia): Unit = {/*...*/}
}
