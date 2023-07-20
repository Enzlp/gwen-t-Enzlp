package cl.uchile.dcc
package gwent.visitor

import cl.uchile.dcc.gwent.cartas.clases.{CombateCuerpoCuerpo, CombateAsedio, CombateDistancia}
import cl.uchile.dcc.gwent.factory.FabricaCartas
import cl.uchile.dcc.gwent.visitorEffects.RMEffectsVisitor
import munit.FunSuite
class RMEffectsTest extends FunSuite{
  val visitor = new RMEffectsVisitor
  val ca: CombateAsedio = new CombateAsedio("nombre", "descripcion",5, 
    false, false)
  val cd: CombateDistancia = new CombateDistancia("nombre", "descripcion",5,
    false, false)
  val cc: CombateCuerpoCuerpo = new CombateCuerpoCuerpo("nombre", "descripcion",5,
    false, false)
  test("Se puede aplicar efecto de refuerzo moral a todas las carta de combate"){
    ca.acceptVisitor(visitor)
    cd.acceptVisitor(visitor)
    cc.acceptVisitor(visitor)
    assert(ca.poderActual == (ca.poder+1))
    assert(cd.poderActual == (cd.poder+1))
    assert(cc.poderActual == (cc.poder+1))
  }
  test("se almacena la carta jugada"){
    visitor.cartaJugada(ca)
    assert(visitor._cartaJugada(0) == ca)
  }
}
