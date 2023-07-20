package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

class CDEffectsVisitor extends AbstractClimateEffectsVisitor {
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    ca.cambiarPoderActual(ca.poder)
  }
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    cc.cambiarPoderActual(cc.poder)
  }
  override def visitCombateCD(cd: CombateDistancia): Unit = {
    cd.cambiarPoderActual(cd.poder)
  }
}
