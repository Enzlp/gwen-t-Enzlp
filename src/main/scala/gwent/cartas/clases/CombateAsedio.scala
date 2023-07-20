package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.ITablero
import cl.uchile.dcc.gwent.cartas.clases.EscarchaMordiente
import cl.uchile.dcc.gwent.visitorEffects.Visitor

/**Clase que crea cartas de unidad del tipo Combate de Asedio
 * Un objeto CombateAsedio es del tipo [[carta]], y por lo tanto posee nombre y descripcion, pero además posee poder asignado
 * a la carta.
 * @constructor Crea un CombateAsedio, con nombre, descripcion y poder
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateAsedio(nombre: String, descripcion: String, poder:Int, vinculoEstrecho: Boolean, refuerzoMoral: Boolean)
  extends AbstractUnidad(nombre,descripcion,poder, vinculoEstrecho, refuerzoMoral){
  /**Jugar una carta en el tablero.
   * El método hace un llamado a la función jugarCartaCA() propia del tablero, para que juegue la carta en la zona apropiada
   * @param tablero: Tablero en el que se jugará la carta
   * @param jugador: Jugador que juega la carta
   */
  override def jugarCarta(tablero: ITablero, jugador: IJugador): Unit = {
    tablero.jugarCartaCA(this, jugador)
  }

  /**Método que acepta un visitor
   *
   * Este método es parte del patrón de diseño Visitor, en el que acepta un visitor externo y lo redirige usando double
   * dispatch a el efecto que debería generar en la carta dentro de la clase concreta de tipo Visitor a la que
   * corresponde el parámetro ingresado
   * @param visitor visitor que "visita" a la clase CombateAsedio
   */
  override def acceptVisitor(visitor: Visitor): Unit = visitor.visitCombateCA(this)
}