package cl.uchile.dcc
package gwent.effectVisitor

import gwent.cartas.clases.CombateAsedio
import cl.uchile.dcc.gwent.effectVisitor.AbstractEffectVisitor

class LtClimateEffect extends AbstractEffectVisitor {
  override def aplicarEfectoCA(card: CombateAsedio): Unit = {
    card.cambiarPoderActual(1)
  }
}
