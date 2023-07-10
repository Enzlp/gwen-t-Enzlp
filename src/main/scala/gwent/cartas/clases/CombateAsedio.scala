package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.ITablero

/**Clase que crea cartas de unidad del tipo Combate de Asedio
 * Un objeto CombateAsedio es del tipo [[carta]], y por lo tanto posee nombre y descripcion, pero además posee poder asignado
 * a la carta.
 * @constructor: Crea un CombateAsedio, con nombre, descripcion y poder
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateAsedio(nombre: String, descripcion: String, poder:Int) extends AbstractUnidad(nombre,descripcion,poder){
  /**Jugar una carta en el tablero.
   * El método hace un llamado a la función recibeCartaCA() propia del tablero, para que juegue la carta en la zona apropiada
   * @param tablero: Tablero en el que se jugará la carta
   * @param jugador: Jugador que juega la carta
   */
  override def jugarCarta(tablero: ITablero, jugador: IJugador): Unit = {
    tablero.jugarCartaCA(this, jugador)
  }
}