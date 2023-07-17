package cl.uchile.dcc
package gwent.effectVisitor

import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}


trait IEffectVisitor {
  def aplicarEfectoCC(card: CombateCuerpoCuerpo): Unit
  def aplicarEfectoCD(card: CombateDistancia): Unit
  def aplicarEfectoCA(card: CombateAsedio): Unit
}
