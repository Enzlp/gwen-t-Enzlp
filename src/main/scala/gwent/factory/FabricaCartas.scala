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
  /** Values que son los nombres y descripción para cada una de las cartas de clima */
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
  
  /** Fabrica que genera nombres, que usaremos para las cartas de Unidad */
  private val fabricaNombres = new FabricaNombresUnidad

  /** Crea un nuevo objeto del tipo [[ClimaDespejado]]
   * Esta función crea una carta de tipo [[ClimaDespejado]], con el nombre 'nombreClimaDespejado' y la descripción 
   * 'descripcionClimaDespejado'
   * @return Una nueva Carta del tipo [[ClimaDespejado]]
   */
  override def createClimaDespejado: ClimaDespejado = {
    new ClimaDespejado(nombreClimaDespejado, descripcionClimaDespejado)
  }

  /** Crea un nuevo objeto del tipo [[EscarchaMordiente]]
   * Esta función crea una carta de tipo [[EscarchaMordiente]], con el nombre 'nombreEscarchaMordiente' y la descripcion
   * 'descripcionEscarchaMordiente'
   *
   * @return Una nueva Carta del tipo [[EscarchaMordiente]]
   */
  override def createEscarchaMordiente: EscarchaMordiente = {
    new EscarchaMordiente(nombreEscarchaMordiente, descripcionEscarchaMordiente)
  }

  /** Crea un nuevo objeto del tipo [[LluviaTorrencial]]
   * Esta función crea una carta de tipo [[LluviaTorrencial]], con el nombre 'nombreLluviaTorrencial' y la descripcion
   * 'descripcionLluviaTorrencial'
   *
   * @return Una nueva Carta del tipo [[LluviaTorrencial]]
   */
  override def createLluviaTorrencial: LluviaTorrencial = {
    new LluviaTorrencial(nombreLluviaTorrencial, descripcionLluviaTorrencial)
  }

  /** Crea un nuevo objeto del tipo [[NieblaImpenetrable]]
   * Esta función crea una carta de tipo [[NieblaImpenetrable]], con le nombre 'nombreNieblaImpenetrable' y la 
   * descripción 'descripcionNieblaImpenetrable'
   *
   * @return Una nueva Carta del tipo [[NieblaImpenetrable]]
   */
  override def createNieblaImpenetrable: NieblaImpenetrable = {
    new NieblaImpenetrable(nombreNieblaImpenetrable, descripcionNieblaImpenetrable)
  }

  /** Crea una nueva Carta del tipo [[CombateCuerpoCuerpo]]
   * Esta función crea una carta del tipo [[CombateCuerpoCuerpo]]. Usa la función 'generateName' de la fabrica 
   * 'fabricaNombres', para generar un nombre para la carta, y usa la función 'Random.between()' para generar de forma 
   * aleatoria el poder de la carta. La función toma los parámetros 'vinculoEstrecho' y 'refuerzoMoral' ambos de tipo 
   * boolean. El primero es para señalar si la carta tendrá el efecto de vinculo estrecho y el segundo para saber si
   * tendrá el efecto de refuerzo moral. 
   *
   * @param vinculoEstrecho true para crear una carta con este efecto
   * @param refuerzoMoral   true para crear una carta con este efecto
   * @return carta de tipo [[CombateCuerpoCuerpo]]
   */
  override def createCloseCombat(vinculoEstrecho: Boolean, refuerzoMoral: Boolean): CombateCuerpoCuerpo = {
    val x: String = fabricaNombres.generateName
    new CombateCuerpoCuerpo(x, "", Random.between(0, 11), vinculoEstrecho, refuerzoMoral)
  }

  /**Crea una nueva Carta del tipo [[CombateDistancia]]
   * Esta función crea una carta del tipo [[CombateDistancia.]]. Usa la función 'generateName' de la fabrica 
   * 'fabricaNombres', para generar un nombre para la carta, y usa la función 'Random.between()' para generar de forma 
   * aleatoria el poder de la carta. La función toma los parámetros 'vinculoEstrecho' y 'refuerzoMoral' ambos de tipo 
   * boolean. El primero es para señalar si la carta tendrá el efecto de vinculo estrecho y el segundo para saber si
   * tendrá el efecto de refuerzo moral. 
   *
   * @param vinculoEstrecho true para crear una carta con este efecto
   * @param refuerzoMoral true para crear una carta con este efecto
   * @return carta de tipo [[CombateDistancia]]
   */
  override def createRangeCombat(vinculoEstrecho: Boolean, refuerzoMoral: Boolean): CombateDistancia = {
    val x: String = fabricaNombres.generateName
    new CombateDistancia(x, "", Random.between(0, 11), vinculoEstrecho, refuerzoMoral)
  }

  /**Crea una nueva Carta del tipo [[CombateAsedio]]
   * Esta función crea una carta del tipo [[CombateDistancia.]]. Usa la función 'generateName' de la fabrica 
   * 'fabricaNombres', para generar un nombre para la carta, y usa la función 'Random.between()' para generar de forma 
   * aleatoria el poder de la carta. La función toma los parámetros 'vinculoEstrecho' y 'refuerzoMoral' ambos de tipo 
   * boolean. El primero es para señalar si la carta tendrá el efecto de vinculo estrecho y el segundo para saber si
   * tendrá el efecto de refuerzo moral. 
   *
   * @param vinculoEstrecho true para crear una carta con este efecto
   * @param refuerzoMoral true para crear una carta con este efecto
   * @return carta de tipo [[CombateAsedio]]
   */
  override def createSiegeCombat(vinculoEstrecho: Boolean, refuerzoMoral: Boolean): CombateAsedio = {
    val x: String = fabricaNombres.generateName
    new CombateAsedio(x, "", Random.between(0, 11), vinculoEstrecho, refuerzoMoral)
  }
  
}
