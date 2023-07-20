package cl.uchile.dcc
package gwent.visitor

import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateDistancia}
import cl.uchile.dcc.gwent.factory.FabricaCartas
import cl.uchile.dcc.gwent.visitorEffects.{LTEffectsVisitor, NIEffectsVisitor}
import munit.FunSuite
class NIEffectsTest extends FunSuite{
  val fabricaCard: FabricaCartas = new FabricaCartas
  val visitor: NIEffectsVisitor = new NIEffectsVisitor
  val cd: CombateDistancia = fabricaCard.createRangeCombat(false, false)
  test("Aplicar efectos de Niebla impenetrable"){
    cd.acceptVisitor(visitor)
    assert(cd.poderActual == 1)
  }
}
