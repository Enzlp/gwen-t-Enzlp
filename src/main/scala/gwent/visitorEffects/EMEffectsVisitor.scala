package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.CombateCuerpoCuerpo

class EMEffectsVisitor extends AbstractClimateEffectsVisitor {
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    cc.cambiarPoderActual(1)
  }
}
