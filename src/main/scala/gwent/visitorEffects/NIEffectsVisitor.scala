package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateCuerpoCuerpo, CombateDistancia}

/**Visitor Concreto para el efecto de niebla impenetrable
 *
 * Esta clase representa un objeto del tipo [[Visitor]] que implementa el efecto de niebla impenetrable en todas las
 * cartas.
 */
class NIEffectsVisitor extends AbstractClimateEffectsVisitor {
  /** Método que aplica el efecto a una carta de [[CombateDistancia]]
   *
   * Este método es parte del double dispatch que aplica el efecto de establecer el valor de fuerza de todas las cartas
   * de combate a distancia en 1
   *
   * @param cd carta de tipo [[CombateDistancia]] a la que se le aplicarán los cambios
   */
  override def visitCombateCD(cd: CombateDistancia): Unit = {
    cd.cambiarPoderActual(1)
  }
}
