package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

class RMEffectsVisitor extends AbstractUnitEffects {
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    ca.cambiarPoderActual(ca.poderActual+1)
  }

  override def visitCombateCD(cd: CombateDistancia): Unit = {
    cd.cambiarPoderActual(cd.poderActual + 1)
  }

  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    cc.cambiarPoderActual(cc.poderActual + 1)
  }

}
