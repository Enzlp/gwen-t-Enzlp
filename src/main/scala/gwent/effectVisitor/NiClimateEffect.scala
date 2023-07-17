package cl.uchile.dcc
package gwent.effectVisitor

import cl.uchile.dcc.gwent.effectVisitor.AbstractEffectVisitor
import cl.uchile.dcc.gwent.cartas.clases.CombateDistancia
class NiClimateEffect extends AbstractEffectVisitor {
  override def aplicarEfectoCD(card: CombateDistancia): Unit ={
    card.cambiarPoderActual(1)
  }
}
