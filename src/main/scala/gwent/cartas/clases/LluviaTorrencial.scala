package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractClima

/**Clase que crea una carta de clima del tipo Lluvia Torrencial
 * Un objeto LLuviaTorrencial es del tipo [[Carta]], y posee nombre y descripcion
 * @constructor: Crea un LLuviaTorrencial con nombre y descripción
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
class LluviaTorrencial(nombre: String, descripcion: String) extends AbstractClima(nombre, descripcion){

}
