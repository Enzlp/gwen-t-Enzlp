package cl.uchile.dcc
package gwent.jugadores

import gwent.jugadores.IJugador
import gwent.cartas.Carta
import gwent.tablero.ITablero

import cl.uchile.dcc.gwent.gemObserver.AbstractSubject

import scala.Equals
import scala.collection.mutable.ArrayBuffer
import scala.util.Random as rand
import cl.uchile.dcc.gwent.gemObserver.Loser

/** Clase que crea un jugador del juego Gwent
 * Un [[Jugador]], es un objeto que posee parámetros nombre, gemas, mano y  mazo. 
 * @constructor Crea un nuevo Jugador, con nombre, gemas, mano y mazo
 * @param nombre: Nombre del Jugador, es del tipo val por lo que no puede ser cambiada
 * @param _gemas: Numero de gemas del jugador, que representará la vida restante
 * @param _mano: Array que representa un subconjunto de cartas jugables del jugador
 * @param _mazo: Array que es un conjunto de cartas disponibles del jugador y que se obtienen de manero
 * ordenada y unitaria
 */
class Jugador (val nombre: String, private var _gemas : Int, private var _mano : ArrayBuffer[Carta]
               ,private var _mazo: ArrayBuffer[Carta]) extends AbstractSubject[Loser] with IJugador {

  /** Método de acceso a las gemas del jugador
   * Es nuestro getter de las gemas del jugador(el hp)
   *@return gemas del jugador
   */
  override def gemas: Int = _gemas

  /**Método de Acceso a la mano del jugador
   * Nos permite ver los elementos en la mano del jugador
   * Es nuestro Getter de la mano
   * @return mano del Jugador
   */
  override def mano: ArrayBuffer[Carta] = _mano

  /** Método de Acceso al mazo del jugador
   * Nos permite ver los elementos en el mazo del jugador
   * Es nuestro Getter del mazo
   * @return mazo del Jugador
   */
  override def mazo: ArrayBuffer[Carta] = _mazo

  /** Roba carta del mazo del jugador
   *  Roba la ultima carta del mazo que representa la carta que esta mas arriba en un mazo físico,
   *  esta Carta es eliminada del mazo original, y añadida a la mano del jugador.
   *  El método retorna la carta robada.
   *  @return Carta que fue robada del mazo
   */
  override def robarCarta(): Carta = {
    val card = mazo.head
    _mano.addOne(card)
    _mazo = mazo.tail
    card
  }

  /**Revuelve el mazo del jugador
   * Toma el array que representa el mazo del jugador, y revuelve los elementos usando rand.shuffle()
   * Podemos definir que este método es un setter.
   */
  override def shuffleMazo(): Unit ={
    _mazo = rand.shuffle(mazo)
  }

  /**Jugar una Carta en el tablero
   * El método toma un indice que indicará la posición de la carta en la mano del jugador, remueve la carta de 
   * la mano, e invoca la función jugarCarta() propia de esa Carta
   * @param indice: indice de la carta a jugar
   */
  override def jugarCarta(indice: Int, board: ITablero): Unit= {
    val card = mano(indice)
    _mano.remove(indice)
    card.jugarCarta(board, this)
  }

  /**Resta una gema de la vida del jugador
   * 
   * Este método resta una gema a las gemas del jugador, si al hacer esta operación se llega a que las gemas del
   * jugador dan 0, entonces se invoca la función notifyObservers, para notificar a los observadores que el jugador
   * perdió el Juego. El parámetro de la función notifyObservers, es un objeto del tipo [[Loser]], con le nombre del 
   * jugador esto se usará después por el suscriptor para determinar quien perdió el juego. 
   */
  override def perderRonda: Unit = {
    _gemas = _gemas-1
    if(_gemas == 0){
      notifyObservers(new Loser(nombre))
    }
  }

}