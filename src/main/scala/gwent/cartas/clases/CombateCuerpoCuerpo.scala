package cl.uchile.dcc
package gwent.cartas.clases

import gwent.cartas.AbstractUnidad

import cl.uchile.dcc.gwent.jugadores.{IJugador, Jugador}
import cl.uchile.dcc.gwent.tablero.ITablero
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.effectVisitor.IEffectVisitor

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
  /** Jugar un carta en el tablero
   * La función delega el jugar la carta al hacer un llamado a la función recibeCartaCC(), propia
   * del objeto tablero, la carta a jugar es la misma carta que invoca el método para esto se usa [[this]]
   *
   * @param tablero : Tablero en el que se jugará la carta
   */
  override def jugarCarta(tablero: ITablero, jugador: IJugador): Unit = {
    tablero.jugarCartaCC(this, jugador)
  }
  override def acceptVisitor(visitor: IEffectVisitor): Unit = visitor.aplicarEfectoCC(this)

}