package cl.uchile.dcc
package gwent.cartas

import gwent.tablero.{ITablero}
import cl.uchile.dcc.gwent.jugadores.IJugador
/**Trait (interfaz) que representa una carta en Gwent
 * Este trait posee 3 declaraciones, 2 propiedades y un método.
 * nombre y descripcion, son dos propiedades de cada tipo de carta y son inmutables, una vez creada la carta su nombre y
 * descripcion no puede ser cambiado.
 * El método jugarCarta(), será heredado por las clases de cartas que implementen este trait, y se implementará en esas clases.
 */
trait Carta {
  
  val nombre: String
  val descripcion: String

  /** Método para jugar un carta en el tablero
   */
  def jugarCarta(tablero: ITablero, jugador: IJugador): Unit
}
