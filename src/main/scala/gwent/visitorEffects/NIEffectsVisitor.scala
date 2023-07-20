package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.CombateDistancia

class NIEffectsVisitor extends AbstractClimateEffectsVisitor {
  override def visitCombateCD(cd: CombateDistancia): Unit = {
    cd.cambiarPoderActual(1)
  }
}
