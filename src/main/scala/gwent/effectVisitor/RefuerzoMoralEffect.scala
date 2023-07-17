package cl.uchile.dcc
package gwent.effectVisitor
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

class RefuerzoMoralEffect extends AbstractEffectVisitor {
  override def aplicarEfectoCA(card: CombateAsedio): Unit = {
    card.cambiarPoderActual(card.poder+1)
  }

  override def aplicarEfectoCC(card: CombateCuerpoCuerpo): Unit = {
    card.cambiarPoderActual(card.poder + 1)
  }

  override def aplicarEfectoCD(card: CombateDistancia): Unit = {
    card.cambiarPoderActual(card.poder + 1)
  }
}
