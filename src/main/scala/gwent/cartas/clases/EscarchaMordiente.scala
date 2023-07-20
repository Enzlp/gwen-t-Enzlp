package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.CartaClima

import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.ITablero
import cl.uchile.dcc.gwent.visitorEffects.EMEffectsVisitor

/**Clase que crea cartas de Clima del tipo Escarcha Mordiente
 * Un objeto EscarchaMordiente es del tipo [[Carta]], y posee nombre y descripcion
 * @constructor Crea un EscarchaMordiente con nombre y descripcion
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
class EscarchaMordiente(nombre: String, descripcion: String) extends CartaClima(nombre, descripcion){

}
