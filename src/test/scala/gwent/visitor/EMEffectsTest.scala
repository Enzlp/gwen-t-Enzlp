package cl.uchile.dcc
package gwent.visitor

import cl.uchile.dcc.gwent.factory.{FabricaCartas, FabricaNombresUnidad}
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.cartas.clases.CombateCuerpoCuerpo

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.visitorEffects.EMEffectsVisitor
import munit.FunSuite
class EMEffectsTest extends FunSuite {
  val fabricaCard: FabricaCartas = new FabricaCartas
  val visitor: EMEffectsVisitor = new EMEffectsVisitor
  val cc: CombateCuerpoCuerpo = fabricaCard.createCloseCombat(false, false)
  test("Aplicar efectos de escarcha mordiente en cartas Combate cuerpo a cuerpo"){
    cc.acceptVisitor(visitor)
    assert(cc.poderActual == 1)
  }

}
