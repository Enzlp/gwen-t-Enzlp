package cl.uchile.dcc
package gwent.jugadores

import gwent.jugadores.IJugador
import gwent.cartas.Carta
import gwent.tablero.{ITableroClima, ITableroUnidad, TableroUnidad}

import scala.Equals
import scala.collection.mutable.ArrayBuffer
import scala.util.Random as rand

/** Clase que crea un jugador del juego Gwent
 * Un [[Jugador]], es un objeto que posee parametros nombre, gemas, mano y  mazo, y además la clase declara una
 * variable llamada board que genera un tablero personal para el jugador donde se jugarán las cartas
 * @param nombre: Nombre del Jugador, es del tipo val por lo que no puede ser cambiada
 * @param _gemas: Numero de gemas del jugador, que representará la vida restante
 * @param _mano: Array que representa un subconjunto de cartas jugables del jugador
 * @param _mazo: Array que es un conjunto de cartas disponibles del jugador y que se obtienen de manero
 * ordenada y unitaria
 * @param boardClima: Tablero compartido entre jugadores donde se juegan las cartas de clima
 */
class Jugador (val nombre: String, private var _gemas : Int, private var _mano : ArrayBuffer[Carta]
               ,private var _mazo: ArrayBuffer[Carta], private var boardClima: ITableroClima ) extends IJugador {
  
  /** Método de acceso a las gemas del jugador
   * Es nuestro getter de las gemas del jugador(el hp)
   *@return gemas del jugador
   */
  override def gemas: Int = _gemas
  /** Parte del tablero personal del jugador
   * Variable privada para no ser cambiada de manera externa
    */             
  private val _personalBoard = new TableroUnidad()
  
  /** Método de Acceso al tablero personal del jugador
   * Nos permite ver los elementos en el tablero personal del jugador
   * Es nuestro getter del tablero personal
   * @return tablero personal del jugador
   */
  override def personalBoard: ITableroUnidad = _personalBoard

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
   * la mano, e invoca la funcion jugarCarta() propia de esa Carta
   * @param indice: indice de la carta a jugar
   */
  override def jugarCarta(indice: Int): Unit= {
    val card = mano(indice)
    _mano.remove(indice)
    card.jugarCarta(personalBoard, boardClima)
  }
}