package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

import cl.uchile.dcc.gwent.visitorEffects.AbstractUnitEffects

/** Visitor Concreto para el efecto de refuerzo moral
 * Esta clase representa un objeto del tipo [[Visitor]] que implementa el efecto de refuerzo moral en todas las
 * cartas de la misma fila.
 */
class VEEffectsVisitor extends AbstractUnitEffects {
  /** Método que aplica el efecto de Refuerzo Moral a una carta
   *
   * Este método es parte del double dispatch que aplica el efecto de de duplicar el valor del poder de la carta si
   * esta comparte nombre con la carta jugada
   *
   * @param ca carta a la que se le aplicará el efecto de tipo [[CombateAsedio]]
   */
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    if (ca.nombre == _cartaJugada(0).nombre) {
      ca.cambiarPoderActual(2 * ca.poderActual)
    }
  }

  /** Método que aplica el efecto de Refuerzo Moral a una carta
   *
   * Este método es parte del double dispatch que aplica el efecto de de duplicar el valor del poder de la carta si
   * esta comparte nombre con la carta jugada
   *
   * @param cc carta a la que se le aplicará el efecto de tipo [[CombateCuerpoCuerpo]]
   */
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    if(cc.nombre == _cartaJugada(0).nombre){
      cc.cambiarPoderActual(2*cc.poderActual)
    }
  }

  /** Método que aplica el efecto de Refuerzo Moral a una carta
   *
   * Este método es parte del double dispatch que aplica el efecto de de duplicar el valor del poder de la carta si
   * esta comparte nombre con la carta jugada
   *
   * @param cd carta a la que se le aplicará el efecto de tipo [[CombateDistancia]]
   */
  override def visitCombateCD(cd: CombateDistancia): Unit ={
    if(cd.nombre == _cartaJugada(0).nombre){
      cd.cambiarPoderActual(2*cd.poderActual)
    }
  }
}
