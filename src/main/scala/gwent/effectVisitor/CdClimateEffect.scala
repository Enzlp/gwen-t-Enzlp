package cl.uchile.dcc
package gwent.effectVisitor
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

class CdClimateEffect extends AbstractEffectVisitor {
  override def aplicarEfectoCA(card: CombateAsedio): Unit = {
    card.cambiarPoderActual(card.poder)
  }
  override def aplicarEfectoCC(card: CombateCuerpoCuerpo): Unit = {
    card.cambiarPoderActual(card.poder)
  }
  override def aplicarEfectoCD(card: CombateDistancia): Unit = {
    card.cambiarPoderActual(card.poder)
  }
}
