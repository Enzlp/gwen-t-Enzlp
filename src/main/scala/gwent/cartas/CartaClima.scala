package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.AbstractCarta

import cl.uchile.dcc.gwent.jugadores.{IJugador, Jugador}
import cl.uchile.dcc.gwent.tablero.ITablero

/** Clase que representa el tipo general de la clase Clima
 * Una CartaClima es del tipo [[Carta]], e implementa el nombre y la descripcion. Además implementa la función
 * jugarCarta que juega esta carta en un tablero especificado mediante el uso de double dispatch
 * @constructor Crea una nueva ´CartaClima´, con nombre y descripcion
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
class CartaClima(nombre: String, descripcion: String)extends AbstractCarta(nombre, descripcion) {
  /**Jugar Carta en el tablero
   * La función delega el jugar la carta al hacer un llamado a la función jugarCartaClima(), propia
   * del objeto tablero
   * @param tablero tablero donde se jugará esta carta
   */
  override def jugarCarta(tablero: ITablero, jugador: IJugador): Unit = {
    tablero.jugarCartaClima(this)
  }

}
