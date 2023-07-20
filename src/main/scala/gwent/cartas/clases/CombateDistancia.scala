package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.visitorEffects.Visitor
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.ITablero
/**Clase que crea cartas unidad de tipo CombateDistancia
 * Un objeto de tipo CombateDistancia es del tipo [[Carta]], por lo que que posee nombre y descripción, y además posee un
 * poder asignado a la carta.
 * @constructor Crea un CombateDistancia, con nombre, descripcion y poder
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateDistancia(nombre:String, descripcion:String, poder:Int, vinculoEstrecho: Boolean, refuerzoMoral: Boolean)
  extends AbstractUnidad(nombre,descripcion, poder, vinculoEstrecho, refuerzoMoral){
  /** Jugar una carta e Combate A Distancia
   * El método hace un llamado a la función jugarCartaCD(), propia del tablero, para jugar la carta en la zona 
   * correspondiente
   * @param jugador jugador que juega esta carta en el tablero 
   * @param tablero : Tablero donde se jugará la carta
   */
  override def jugarCarta(tablero: ITablero, jugador: IJugador): Unit = {
    tablero.jugarCartaCD(this, jugador)
  }

  /** Método que acepta un visitor
   *
   * Este método es parte del patrón de diseño Visitor, en el que acepta un visitor externo y lo redirige usando double
   * dispatch a el efecto que debería generar en la carta dentro de la clase concreta de tipo Visitor a la que
   * corresponde el parámetro ingresado
   *
   * @param visitor visitor que "visita" a la clase CombateAsedio
   */
  override def acceptVisitor(visitor: Visitor): Unit = visitor.visitCombateCD(this)
}
