package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.AbstractZonaUnidad
import scala.collection.mutable.ArrayBuffer

/**Representa una zona de tipo combate de asedio
 * 
 * Una Zona de Combate de Asedio, es un objeto que posee dos filas, cada una representada por un arreglo de tipo 
 * [[ArrayBuffer]]. El objeto se crea con dos propietarios del tipo [[IJugador]], estos dos son los únicos jugadores que
 * pueden jugar en esta zona, y cada uno posee un fila propia. 
 * @constructor Crea una nueva Zona del tipo combate de asedio, con dos propietarios de tipo [[IJugador]]
 * @param owner1 jugador 1 que juega en esta zona
 * @param owner2 jugador 2 que juega en esta zona
 */
class ZonaCA(owner1: IJugador, owner2: IJugador) extends AbstractZonaUnidad(owner1, owner2) {

}
