package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.CombateAsedio

class LTEffectsVisitor extends AbstractClimateEffectsVisitor {
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    ca.cambiarPoderActual(1)
  }
}
