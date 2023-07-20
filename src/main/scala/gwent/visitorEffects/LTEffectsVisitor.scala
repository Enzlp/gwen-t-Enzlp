package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.CombateAsedio

/**Visitor Concreto para el efecto de lluvia torrencial
 *
 * Esta clase representa un objeto del tipo [[Visitor]] que implementa el efecto de Lluvia Torrencial en todas las
 * cartas.
 */
class LTEffectsVisitor extends AbstractClimateEffectsVisitor {
  /** Método que aplica el efecto a una carta de [[CombateAsedio]]
   *
   * Este método es parte del double dispatch que aplica el efecto de establecer el valor de fuerza de todas las cartas
   * de asedio en 1
   *
   * @param ca carta de tipo [[CombateAsedio]] a la que se le aplicarán los cambios
   */
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    ca.cambiarPoderActual(1)
  }
}
