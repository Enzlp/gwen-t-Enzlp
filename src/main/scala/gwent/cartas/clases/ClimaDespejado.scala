package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.CartaClima


/**Clase ClimaDespejado, representa una carta de Clima del tipo Clima Despejado
 * Un objeto ClimaDespejado es del tipo [[Carta]], por lo que posee un nombre y descripción
 * @constructor Cre un CLimaDespejado con nombre y descripción
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
class ClimaDespejado(nombre: String, descripcion: String) extends CartaClima(nombre, descripcion){
  
}
