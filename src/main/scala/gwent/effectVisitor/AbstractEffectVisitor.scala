package cl.uchile.dcc
package gwent.effectVisitor

import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import cl.uchile.dcc.gwent.effectVisitor.IEffectVisitor
import cl.uchile.dcc.gwent.cartas.Carta
import scala.collection.mutable.ArrayBuffer
abstract class AbstractEffectVisitor extends IEffectVisitor {
  protected var cartaJugada: ArrayBuffer[Carta] = ArrayBuffer[Carta]()

  def cardPlayed(card: Carta): Unit = {
    cartaJugada:+card
  }
  def effectApplied: Unit = {cartaJugada.clear()}
  override def aplicarEfectoCA(card: CombateAsedio): Unit = {/*...*/}
  override def aplicarEfectoCC(card: CombateCuerpoCuerpo): Unit = {/*...*/}
  override def aplicarEfectoCD(card: CombateDistancia): Unit = {/*...*/}

}
