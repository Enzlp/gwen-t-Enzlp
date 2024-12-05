package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.CartaClima

/**Clase que crea cartas de Clima del tipo Niebla Impenetrable
 * Una NieblaImpenetrable es del tipo [[Carta]], que posee nombre y descripcion
 * @constructor: Crea un nuevo NieblaImpenetrable con nombre y descripción
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
class NieblaImpenetrable(nombre:String, descripcion: String) extends CartaClima(nombre, descripcion){

}
