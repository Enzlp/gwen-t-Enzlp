package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
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

  }
  test("Fabrica permite crear Carta del tipo Escarcha Mordiente") {

  }
  test("Fabrica permite crear Carta del tipo Lluvia torrencial") {

  }
  test("Fabrica permite crear Carta del tipo Niebla Impenetrable") {

  }
}
