package cl.uchile.dcc
package gwent.factory

import gwent.cartas.Carta

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, CombateDistancia, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}

trait IFabricaCartas {
  /** Método que crea una carta del tipo [[ClimaDespejado]] */
  def createClimaDespejado: ClimaDespejado
  /** Método que crea una carta del tipo [[EscarchaMordiente]] */
  def createEscarchaMordiente: EscarchaMordiente
  /** Método que crea una carta del tipo [[LluviaTorrencial]] */
  def createLluviaTorrencial: LluviaTorrencial
  /** Método que crea una carta del tipo [[NieblaImpenetrable]] */
  def createNieblaImpenetrable: NieblaImpenetrable
  /** Método que crea una carta del tipo [[CombateCuerpoCuerpo]] */
  def createCloseCombat(vinculoEstrecho: Boolean, refuerzoMoral: Boolean): CombateCuerpoCuerpo
  /** Método que crea una carta del tipo [[CombateDistancia]] */
  def createRangeCombat(vinculoEstrecho:Boolean, refuerzoMoral: Boolean): CombateDistancia
  /** Método que crea una carta del tipo [[CombateAsedio]] */
  def createSiegeCombat(vinculoEstrecho: Boolean, refuerzoMoral: Boolean): CombateAsedio
}
