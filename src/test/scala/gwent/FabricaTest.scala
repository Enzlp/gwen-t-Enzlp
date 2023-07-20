package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateCuerpoCuerpo, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
import cl.uchile.dcc.gwent.factory.FabricaCartas
import munit.FunSuite
class FabricaTest extends FunSuite {
  private val climaDespejado = new ClimaDespejado("Clima Despejado", "Elimina todos los efectos climáticos" +
    " actualmente en efecto en el campo de batalla")
  private val escarchaMordiente = new EscarchaMordiente("Escarcha Mordiente", "Establece el valor de " +
    "fuerza de todas las cartas de combate cuerpo a cuerpo en 1.")
  private val lluviaTorrencial = new LluviaTorrencial("Lluvia Torrencial", "Establece el valor de todas" +
    " las cartas de asedio a 1")
  private val nieblaImpenetrable = new NieblaImpenetrable("Niebla Impenetrable", "Establece el valor" +
    " de fuerza de todas las cartas de combate a distancia a 1")
  private val fabricaCartas = new FabricaCartas
  test("Fabrica permite crear Carta del tipo Clima Despejado") {
    val card = fabricaCartas.createClimaDespejado
    assertEquals(climaDespejado.nombre, card.nombre)
    assertEquals(climaDespejado.descripcion, card.descripcion)
    assert(card.isInstanceOf[ClimaDespejado])
  }
  test("Fabrica permite crear Carta del tipo Escarcha Mordiente") {
    val card = fabricaCartas.createEscarchaMordiente
    assertEquals(escarchaMordiente.nombre, card.nombre)
    assertEquals(escarchaMordiente.descripcion, card.descripcion)
    assert(card.isInstanceOf[EscarchaMordiente])
  }
  test("Fabrica permite crear Carta del tipo Lluvia torrencial") {
    val card = fabricaCartas.createLluviaTorrencial
    assertEquals(lluviaTorrencial.nombre, card.nombre)
    assertEquals(lluviaTorrencial.descripcion, card.descripcion)
    assert(card.isInstanceOf[LluviaTorrencial])
  }
  test("Fabrica permite crear Carta del tipo Niebla Impenetrable") {
    val card = fabricaCartas.createNieblaImpenetrable
    assertEquals(nieblaImpenetrable.nombre, card.nombre)
    assertEquals(nieblaImpenetrable.descripcion, card.descripcion)
    assert(card.isInstanceOf[NieblaImpenetrable])
  }
  test("Fabrica permite crear Cartas del tipo combate Cuerpo a Cuerpo sin efecto"){
    val card = fabricaCartas.createCloseCombat(false, false)
    assert(card.isInstanceOf[CombateCuerpoCuerpo])
  }
}
