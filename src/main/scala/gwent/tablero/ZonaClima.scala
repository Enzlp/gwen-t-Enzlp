package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.jugadores.IJugador

import scala.collection.mutable.ArrayBuffer

/**Representa la zona de clima del Tablero
 *
 * Una [[ZonaClima]], es un tipo de zona en el que se juegan las cartas de clima en el tablero al que pertenece.
 * Posee la característica de que solo puede haber una carta en juego a la vez.
 * Esta compuesta de un arreglo del tipo [[ArrayBuffer]], que contiene la carta que está en juego. Además posee los
 * métodos recibeCartaClima(card: Carta), que posiciona la cata en el arreglo, y el método areaJuego que permite mostrar
 * el área de juego actual.
 * @constructor crea una nueva zona de clima, con su propia área de juego
 */
class ZonaClima extends IZonaClima {
  /** área de juego, donde se coloca la carta de clima */
  private var _areaJuego = ArrayBuffer[Carta]()

  /**Inserta la carta en el arreglo de área de Juego
   *
   * Este método toma un parámetro de tipo [[Carta]], y lo inserta en el arreglo '_areaJuego'. Para esto, primero limpia
   * el arreglo usando clear(), ya que solo puede haber una carta de Clima en juego, y luego inserta en el arreglo
   * usando la función addOne, que es lo mismo que usar el operador ':+'.
   * @param card: Carta que se va a añadir al area de juego
   */
  override def recibeCartaClima(card: Carta): Unit = {
    _areaJuego.clear()
    _areaJuego.addOne(card)
  }

  /**Muestra el arreglo que representa el área de juego
   *
   * Este método crea una copia del arreglo que representa el área de juego, y lo retorna, así no se arriesga a que la
   * variable '_areaJuego' sea manipulada por externos.
   * @return una copia del arreglo que representa el área de juego
   */
  override def areaJuego: ArrayBuffer[Carta] ={
    val x = _areaJuego
    x
  }
}
