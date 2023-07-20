package cl.uchile.dcc
package gwent.visitor

import cl.uchile.dcc.gwent.factory.FabricaCartas
import cl.uchile.dcc.gwent.visitorEffects.LTEffectsVisitor
import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateDistancia}
import munit.FunSuite
class LTEffectsTest extends FunSuite{
  val fabricaCard: FabricaCartas = new FabricaCartas
  val visitor: LTEffectsVisitor = new LTEffectsVisitor
  val ca: CombateAsedio = fabricaCard.createSiegeCombat(false, false)
  test("Aplicar efectos de Lluvia Torrencial"){
    ca.acceptVisitor(visitor)
    assert(ca.poderActual == 1)
  }
}
