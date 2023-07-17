package cl.uchile.dcc
package gwent.factory

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.cartas.clases.{ClimaDespejado, CombateAsedio, CombateCuerpoCuerpo, 
  CombateDistancia, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
import cl.uchile.dcc.gwent.factory.FabricaNombresUnidad
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import cl.uchile.dcc.gwent.factory.IFabricaCartas
class FabricaCartas extends IFabricaCartas {
  private val nombreClimaDespejado = "Clima Despejado"
  private val descripcionClimaDespejado = "Elimina todos los efectos climáticos" +
    " actualmente en efecto en el campo de batalla"
  private val nombreEscarchaMordiente = "Escarcha Mordiente"
  private val descripcionEscarchaMordiente = "Establece el valor de " +
    "fuerza de todas las cartas de combate cuerpo a cuerpo en 1."
  private val nombreLluviaTorrencial = "Lluvia Torrencial"
  private val descripcionLluviaTorrencial = "Establece el valor de todas" +
    " las cartas de asedio a 1"
  private val nombreNieblaImpenetrable = "Niebla Impenetrable"
  private val descripcionNieblaImpenetrable = "Establece el valor" +
    " de fuerza de todas las cartas de combate a distancia a 1"
  private val fabricaNombres = new FabricaNombresUnidad

  override def createClimaDespejado: Carta = {
    new ClimaDespejado(nombreClimaDespejado, descripcionClimaDespejado)
  }
  override def createEscarchaMordiente: Carta ={
    new EscarchaMordiente(nombreEscarchaMordiente,descripcionEscarchaMordiente)
  }

  override def createLluviaTorrencial: Carta = {
    new LluviaTorrencial(nombreLluviaTorrencial, descripcionLluviaTorrencial)
  }

  override def createNieblaImpenetrable: Carta = {
    new NieblaImpenetrable(nombreNieblaImpenetrable, descripcionNieblaImpenetrable)
  }
  override def createCloseCombat: Carta = {
    val x: String = fabricaNombres.generateName
    new CombateCuerpoCuerpo( x, "", Random.between(0,11))
  }
  override def createRangeCombat: Carta ={
    val x: String = fabricaNombres.generateName
    new CombateDistancia(x, "", Random.between(0,11))
  }

  override def createSiegeCombat: Carta = {
    val x: String = fabricaNombres.generateName
    new CombateAsedio(x, "", Random.between(0, 11))
  }
  
}
