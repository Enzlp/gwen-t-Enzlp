package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

/** Visitor Concreto para el efecto de refuerzo moral
 * Esta clase representa un objeto del tipo [[Visitor]] que implementa el efecto de refuerzo moral en todas las
 * cartas de la misma fila.
 */
class RMEffectsVisitor extends AbstractUnitEffects {
  /**Método que aplica el efecto de Refuerzo Moral a una carta
   *
   * Este método es parte del double dispatch que aplica el efecto de sumarle 1 a la fuerza de todas las cartas de la
   * fila
   * @param ca carta a la que se le aplicará el efecto de tipo [[CombateAsedio]]
   */
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    ca.cambiarPoderActual(ca.poderActual+1)
  }
  /** Método que aplica el efecto de Refuerzo Moral a una carta
   *
   * Este método es parte del double dispatch que aplica el efecto de sumarle 1 a la fuerza de todas las cartas de la
   * fila
   *
   * @param cd carta a la que se le aplicará el efecto de tipo [[CombateDistancia]]
   */
  override def visitCombateCD(cd: CombateDistancia): Unit = {
    cd.cambiarPoderActual(cd.poderActual + 1)
  }

  /** Método que aplica el efecto de Refuerzo Moral a una carta
   *
   * Este método es parte del double dispatch que aplica el efecto de sumarle 1 a la fuerza de todas las cartas de la
   * fila
   *
   * @param cc carta a la que se le aplicará el efecto de tipo [[CombateCuerpoCuerpo]]
   */
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    cc.cambiarPoderActual(cc.poderActual + 1)
  }

}
