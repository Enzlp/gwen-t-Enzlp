package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.tablero.{ITableroClima, ITableroUnidad}
class CombateDistancia(nombre:String, descripcion:String, poder:Int)
  extends AbstractUnidad(nombre,descripcion, poder){
  /**Juegar una carta e Combate A Distancia
   * El método hace un llamado a la funcion recibeCartaCD(), propia del tablero, para jugar la carta en la zona correspondiente
   * @param tablero: Tablero donde se jugará la 
   * @param tableroC: Tablero de clima, no se usará en esta función, esta ahí para poder usar la misma interfaz de Carta
   */
  override def jugarCarta(tablero: ITableroUnidad, tableroC: ITableroClima): Unit ={
    tablero.recibeCartaCD(this)
  }
  
}
