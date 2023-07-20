package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

abstract class AbstractClimateEffectsVisitor extends Visitor {
  override def visitCombateCA(ca: CombateAsedio): Unit = {/*...*/}
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {/*...*/}
  override def visitCombateCD(cd: CombateDistancia): Unit = {/*...*/}
}
