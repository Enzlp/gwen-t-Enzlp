package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad
import cl.uchile.dcc.gwent.tablero.{ITableroClima, ITableroUnidad}
/**Clase que crea cartas unidad de tipo CombateDistancia
 * Un objeto de tipo CombateDistancia es del tipo [[Carta]], por lo que que posee nombre y descripción, y además posee un
 * poder asignado a la carta.
 * @constructor: Crea un CombateDistancia, con nombre, descripcion y poder
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateDistancia(nombre:String, descripcion:String, poder:Int)
  extends AbstractUnidad(nombre,descripcion, poder){
  /**Jugar una carta e Combate A Distancia
   * El método hace un llamado a la funcion recibeCartaCD(), propia del tablero, para jugar la carta en la zona correspondiente
   * @param tableroU: Tablero donde se jugará la carta
   * @param tableroC: Tablero de clima, no se usará en esta función, esta ahí para poder usar la misma interfaz de Carta
   */
  override def jugarCarta(tableroU: ITableroUnidad, tableroC: ITableroClima): Unit = {
    tableroU.recibeCarta(this)
  }

  def update(carta: NieblaImpenetrable): Unit = {
    this._poderActual = 1
  }

  def update(carta: ClimaDespejado): Unit = {
    this._poderActual = poder
  }
}
