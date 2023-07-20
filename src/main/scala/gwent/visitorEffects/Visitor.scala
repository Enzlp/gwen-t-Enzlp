package cl.uchile.dcc
package gwent.visitorEffects

import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

/**Interfaz propia del patrón de diseño Visitor */
trait Visitor {
  /** Método para visitar una carta de la clase [[CombateCuerpoCuerpo]], y aplicar el efecto pertinente */
  def visitCombateCC(cc: CombateCuerpoCuerpo): Unit
  /** Método para visitar una carta de la clase [[CombateAsedio]], y aplicar el efecto pertinente */
  def visitCombateCA(ca: CombateAsedio): Unit
  /** Método para visitar una carta de la clase [[CombateDistancia]], y aplicar el efecto pertinente */
  def visitCombateCD(cd: CombateDistancia): Unit
}
