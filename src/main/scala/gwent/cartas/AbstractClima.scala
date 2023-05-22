package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.AbstractCarta

import cl.uchile.dcc.gwent.tablero.ITablero

/** Clase Abstracta que representa el tipo general de la clase Clima
 * 
 * @constructor Crea una nueva ´AbstractCLima´, con nombre y descripcion
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 */
abstract class AbstractClima(nombre: String, descripcion: String)extends AbstractCarta(nombre, descripcion) {
  /**Jugar Carta en el tablero
   * La funcion delega el jugar la carta al hacer un llamado a la función recibeCartaClima(), propia
   * del objeto tablero
   * @param tablero: Tablero en el que se jugará la carta
   */
  override def jugarCarta(tablero: ITablero): Unit = {
    tablero.recibeCartaClima(this)
  }
}
