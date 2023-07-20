package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo}

/**Visitor Concreto para el efecto de escarcha mordiente
 *
 * Esta clase representa un objeto del tipo [[Visitor]] que implementa el efecto de escarcha mordiente en todas las
 * cartas.
 */
class EMEffectsVisitor extends AbstractClimateEffectsVisitor {
  /** Método que aplica el efecto a una carta de [[CombateCuerpoCuerpo]]
   *
   * Este método es parte del double dispatch que aplica el efecto de establecer el valor de fuerza de todas las cartas
   * de combate cuerpo a cuerpo en 1
   * @param cc carta de tipo [[CombateCuerpoCuerpo]] a la que se le aplicarán los cambios
   */
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    cc.cambiarPoderActual(1)
  }
}
