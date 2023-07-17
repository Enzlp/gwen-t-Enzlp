package cl.uchile.dcc
package gwent.effectComposite

import cl.uchile.dcc.gwent.cartas.Carta
trait Effect {
  def apply(self: Carta, target: Carta): Unit
}
