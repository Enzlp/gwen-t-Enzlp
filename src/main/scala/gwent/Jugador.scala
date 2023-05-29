package cl.uchile.dcc
package gwent

import gwent.IJugador
import gwent.cartas.Carta
import scala.Equals
import scala.collection.mutable.ArrayBuffer
import scala.util.Random as rand
import gwent.tablero.{ITableroClima, TableroUnidad, ITableroUnidad}


/** Clase que crea un jugador del juego Gwent
 * Un [[Jugador]], es un objeto que posee parametros nombre, gemas, mano y  mazo, y además la clase declara una
 * variable llamada board que genera un tablero personal para el jugador donde se jugarán las cartas
 *
 * @param nombre: Nombre del Jugador
 * @param gemas: Numero de gemas del jugador, que representará la vida restante
 * @param _mano: Array que representa un subconjunto de cartas jugables del jugador
 * @param _mazo: Array que es un conjunto de cartas disponibles del jugador y que se obtienen de manero
 * ordenada y unitaria
 */
class Jugador (val nombre: String, var gemas : Int, private var _mano : ArrayBuffer[Carta]
               ,private var _mazo: ArrayBuffer[Carta], private var boardClima: ITableroClima ) extends IJugador {
  /** Parte del tablero personal del jugador 
    */             
  private val board = new TableroUnidad()
  override def personalBoard: ITableroUnidad = board

  override def mano: ArrayBuffer[Carta] = _mano

  override def mazo: ArrayBuffer[Carta] = _mazo

  /** Roba carta del mazo del jugador
   *  Roba la ultima carta del mazo que representa la carta que esta mas arriba en un mazo físico,
   *  esta Carta es eliminada del mazo original, y añadida a la mano del jugador.
   *  El método retorna la carta robada.
   *  @return Carta que fue robada del mazo
   */
  override def robarCarta(): Carta = {
    val card = mazo.last;
    mano.addOne(card);
    mazo.dropRight(1);
    card
  }

  /**Revuelve el mazo del jugador
   * Toma el array que representa el mazo del jugador, y revuelve los elementos usando rand.shuffle()
   */
  override def shuffleMazo(): Unit ={
    _mazo = rand.shuffle(mazo)
  }

  /**Jugar una Carta en el tablero
   * El método toma un indice que indicará la posición de la carta en la mano del jugador, remueve la carta de 
   * la mano, e invoca la funcion jugarCarta() propia de esa Carta
   * @param indice: indice de la carta a jugar
   */
  override def jugarCarta(indice: Int): Unit= {
    val card = mano(indice)
    mano.remove(indice)
    card.jugarCarta(personalBoard, boardClima)
  }


}
