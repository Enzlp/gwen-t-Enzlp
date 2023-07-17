package cl.uchile.dcc
package gwent.factory

import gwent.cartas.Carta

trait IFabricaCartas {
  def createClimaDespejado: Carta
  def createEscarchaMordiente: Carta
  def createLluviaTorrencial: Carta
  def createNieblaImpenetrable: Carta

  def createCloseCombat: Carta
  def createRangeCombat: Carta
  def createSiegeCombat: Carta
}
