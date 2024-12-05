package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.tablero.{ITableroClima, ITableroUnidad}

/**Clase que crea cartas de Unidad del tipo Combate Cuerpo a Cuerpo
 * Un objeto CombateCuerpoCuerpo, es del tipo [[Carta]] por lo que posee un nombre y descripcion, y además un 
 * poder asignado a la carta.
 * @constructor: Crea un CombateCuerpoCuerpo con nombre, descripcion y poder.
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateCuerpoCuerpo(nombre: String, descripcion: String, poder: Int)
  extends AbstractUnidad(nombre,descripcion,poder) {
  /**Jugar un carta en el tablero
   * La funcion delega el jugar la carta al hacer un llamado a la función recibeCartaCC(), propia
   * del objeto tablero, la carta a jugar es la misma carta que invoca el método para esto se usa [[this]]
   * @param tableroU: Tablero en el que se jugará la carta
   * @param tableroC: Tablero de clima, no se usará en esta función, esta ahí para poder usar la misma interfaz de Carta
   */
  override def jugarCarta(tableroU: ITableroUnidad, tableroC: ITableroClima): Unit = {
    tableroU.recibeCartaCC(this)
  }
}