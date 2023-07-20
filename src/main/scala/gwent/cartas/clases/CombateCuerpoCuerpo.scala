package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.jugadores.{IJugador, Jugador}
import cl.uchile.dcc.gwent.tablero.ITablero
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.visitorEffects.Visitor

/**Clase que crea cartas de Unidad del tipo Combate Cuerpo a Cuerpo
 * Un objeto CombateCuerpoCuerpo, es del tipo [[Carta]] por lo que posee un nombre y descripcion, y además un 
 * poder asignado a la carta.
 * @constructor Crea un CombateCuerpoCuerpo con nombre, descripcion y poder.
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
class CombateCuerpoCuerpo(nombre: String, descripcion: String, poder: Int, vinculoEstrecho: Boolean, refuerzoMoral: Boolean)
  extends AbstractUnidad(nombre,descripcion,poder, vinculoEstrecho, refuerzoMoral) {
  /** Jugar un carta en el tablero
   * La función delega el jugar la carta al hacer un llamado a la función jugarCartaCC(), propia
   * del objeto tablero, la carta a jugar es la misma carta que invoca el método para esto se usa [[this]]
   * @param jugador: jugador que va a jugar la carta
   * @param tablero : Tablero en el que se jugará la carta
   */
  override def jugarCarta(tablero: ITablero, jugador: IJugador): Unit = {
    tablero.jugarCartaCC(this, jugador)
  }

  /**Método que acepta un visitor 
   * 
   * Este método es parte del patrón de diseño Visitor, en el que acepta un visitor externo y lo redirige usando double
   * dispatch a el efecto que debería generar en la carta dentro de la clase concreta de tipo Visitor a la que
   * corresponde el parámetro ingresado
   *
   * @param visitor visitor que "visita" a esta clase
   */
  override def acceptVisitor(visitor: Visitor): Unit = visitor.visitCombateCC(this)

}