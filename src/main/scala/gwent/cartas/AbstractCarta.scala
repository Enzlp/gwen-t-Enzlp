package cl.uchile.dcc
package gwent.cartas

/** Clase Abstract que representa una carta en el juego
 * Esta Clase implementa los parámetro del trait [[Carta]], nombre y descripcion
 * @constructor Crea una nueva `AbstractCarta`, que posee nombre y descripcion
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
abstract class AbstractCarta protected(val nombre: String, val descripcion: String) extends Carta {

}
