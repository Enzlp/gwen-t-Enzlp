package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad
import cl.uchile.dcc.gwent.tablero.ITablero
class CombateDistancia(nombre:String, descripcion:String, poder:Int)
  extends AbstractUnidad(nombre,descripcion, poder){
  /**Juegar una carta e Combate A Distancia
   * El método hace un llamado a la funcion recibeCartaCD(), propia del tablero, para jugar la carta en la zona correspondiente
   * @param tablero: Tablero donde se jugará la carta
   */
  override def jugarCarta(tablero: ITablero): Unit ={
    tablero.recibeCartaCD(this)
  }
  
}
