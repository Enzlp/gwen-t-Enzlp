package cl.uchile.dcc
package gwent.visitor

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import cl.uchile.dcc.gwent.factory.{FabricaCartas, FabricaNombresUnidad}
import cl.uchile.dcc.gwent.jugadores.Jugador
import cl.uchile.dcc.gwent.visitorEffects.{CDEffectsVisitor, EMEffectsVisitor, LTEffectsVisitor, NIEffectsVisitor}
class CDEffectsTest extends FunSuite {
  val fabricaCard: FabricaCartas = new FabricaCartas
  val visitor1: EMEffectsVisitor = new EMEffectsVisitor
  val visitor2: LTEffectsVisitor = new LTEffectsVisitor
  val visitor3: NIEffectsVisitor = new NIEffectsVisitor
  val visitor4: CDEffectsVisitor = new CDEffectsVisitor
  var cc: CombateCuerpoCuerpo = fabricaCard.createCloseCombat(false, false )
  var cd: CombateDistancia = fabricaCard.createRangeCombat(false, false)
  var ca: CombateAsedio = fabricaCard.createSiegeCombat(false, false)
  test("El visitor debe de poder aplicar los efectos de carta de clima despejado a cartas de cuerpo a cuerpo"){
    cc.acceptVisitor(visitor1)
    cc.acceptVisitor(visitor4)
    assert(cc.poderActual == cc.poder)
  }
  test("El visitor debe de poder aplicar los efectos de carta de clima despejado a cartas a distancia") {
    cd.acceptVisitor(visitor3)
    cd.acceptVisitor(visitor4)
    assert(cd.poderActual == cd.poder)
  }
  test("El visitor debe de poder aplicar lso efecto de carta de clima despejado a cartas de asedio"){
    ca.acceptVisitor(visitor2)
    ca.acceptVisitor(visitor4)
    assert(ca.poderActual == ca.poder)
  }
}
