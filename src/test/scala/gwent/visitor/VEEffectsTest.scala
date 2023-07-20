package cl.uchile.dcc
package gwent.visitor

import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import cl.uchile.dcc.gwent.factory.FabricaCartas
import cl.uchile.dcc.gwent.visitorEffects.{RMEffectsVisitor, VEEffectsVisitor}
import munit.FunSuite
class VEEffectsTest extends FunSuite{
  val fabricaCard = new FabricaCartas
  val visitor = new VEEffectsVisitor
  val ca: CombateAsedio = fabricaCard.createSiegeCombat(false, false)
  val cd: CombateDistancia = fabricaCard.createRangeCombat(false, false)
  val cc: CombateCuerpoCuerpo = fabricaCard.createCloseCombat(false, false)
  test("Se puede aplicar efecto de vinculo estrecho a todas las carta de combate") {
    visitor.cartaJugada(ca)
    ca.acceptVisitor(visitor)
    assert(ca.poderActual == (2*ca.poder))
    visitor.cartaJugada(cd)
    cd.acceptVisitor(visitor)
    assert(cd.poderActual == (2*cd.poder))
    visitor.cartaJugada(cc)
    cc.acceptVisitor(visitor)
    assert(cc.poderActual == (2*cc.poder))
  }
}
