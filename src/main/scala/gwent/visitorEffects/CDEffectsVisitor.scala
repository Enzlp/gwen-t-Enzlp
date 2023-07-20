package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

/**Visitor Concreto para el efecto de clima despejado
 * 
 * Esta clase representa un objeto del tipo [[Visitor]] que implementa el efecto de clima despejado en todas las cartas,
 * este efecto genera que se anulen todos los efectos anteriores
 */
class CDEffectsVisitor extends AbstractClimateEffectsVisitor {
  /**Método que aplica el efecto a una carta de [[CombateAsedio]]
   * 
   * Este método es parte del double dispatch que aplica el efecto de anular todos los efectos anteriores a la carta que
   * lo invoca esta es ca. Usa la función cambiarPoderActual, para volver la carta al poder con que se definió al
   * crearla. 
   * @param ca carta de tipo [[CombateAsedio]] a la que se le aplicarán los cambios
   */
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    ca.cambiarPoderActual(ca.poder)
  }

  /** Método que aplica el efecto a una carta de [[CombateCuerpoCuerpo]]
   *
   * Este método es parte del double dispatch que aplica el efecto de anular todos los efectos anteriores a la carta que
   * lo invoca esta es cc. usa la función cambiarPoderActual, para volver la carta al poder con que se definió al
   * crearla. 
   *
   * @param cc carta de tipo [[CombateCuerpoCuerpo]] a la que se le aplicarán los cambios
   */
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    cc.cambiarPoderActual(cc.poder)
  }

  /** Método que aplica el efecto a una carta de [[CombateDistancia]]
   *
   * Este método es parte del double dispatch que aplica el efecto de anular todos los efectos anteriores a la carta que
   * lo invoca esta es cd. Usa la función cambiarPoderActual, para volver la carta al poder con que se definió al
   * crearla. 
   *
   * @param cd carta de tipo [[CombateDistancia]] a la que se le aplicarán los cambios
   */
  override def visitCombateCD(cd: CombateDistancia): Unit = {
    cd.cambiarPoderActual(cd.poder)
  }
}
