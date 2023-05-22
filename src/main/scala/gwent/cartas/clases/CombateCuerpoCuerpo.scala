package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.tablero.ITablero

/**Clase que crea cartas de Unidad del tipo Combate Cuerpo a Cuerpo
 *
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateCuerpoCuerpo(nombre: String, descripcion: String, poder: Int)
  extends AbstractUnidad(nombre,descripcion,poder) {
  /**Jugar un carta en el tablero
   * La funcion delega el jugar la carta al hacer un llamado a la función recibeCartaCC(), propia
   * del objeto tablero
   * @param tablero: Tablero en el que se jugará la carta
   */
  override def jugarCarta(tablero: ITablero): Unit = {
    tablero.recibeCartaCC(this)
  }
}