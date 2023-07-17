package cl.uchile.dcc
package gwent.effectVisitor

import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import cl.uchile.dcc.gwent.effectVisitor.AbstractEffectVisitor
class EmClimateEffect extends AbstractEffectVisitor {
  override def aplicarEfectoCC(card: CombateCuerpoCuerpo): Unit = {
    if (cartaJugada(0).nombre == card.nombre) {
      card.cambiarPoderActual(2*card.poderActual)
    }
  }

  override def aplicarEfectoCA(card: CombateAsedio): Unit = {
    if(cartaJugada(0).nombre == card.nombre){
      card.cambiarPoderActual(2*card.poderActual)
    }
  }

  override def aplicarEfectoCD(card: CombateDistancia): Unit = {
    if(cartaJugada(0).nombre == card.nombre){
      card.cambiarPoderActual(2*card.poderActual)
    }
  }
}
