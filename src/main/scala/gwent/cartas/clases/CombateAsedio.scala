package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.tablero.{ITableroClima, ITableroUnidad}

/**Clase que crea cartas de unidad del tipo Combate de Asedio
 * 
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateAsedio(nombre: String, descripcion: String, poder:Int) extends AbstractUnidad(nombre,descripcion,poder){
  /**Jugar una carta en el tablero.
   * El método hace un llamado a la función recibeCartaCA() propia del tablero, para que juegue la carta en la zona apropiada
   * @param tableroU: Tablero en el que se jugará la carta
   * @param tableroC: Tablero de clima, no se usará en esta función, esta ahí para poder usar la misma interfaz de Carta
   */
  override def jugarCarta(tableroU: ITableroUnidad, tableroC: ITableroClima): Unit = {
    tableroU.recibeCartaCA(this)
  }
}