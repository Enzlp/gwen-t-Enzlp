package cl.uchile.dcc
package gwent.tablero

import cl.uchile.dcc.gwent.jugadores.IJugador
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.tablero.IZonaUnidad

/**Clase abstracta
 * Representa la estructura básica que deben tener todas las zonas de unidad. Como es una clase abstracta, esta clase
 * no existe por lo que no se puede instanciar (No se puede hacer referencia a esta clase).
 * @param owner1 jugador 1 que juega en esta zona
 * @param owner2 jugador 2 que juega en esta zona
 */
abstract class AbstractZonaUnidad(val owner1: IJugador, val owner2: IJugador) extends IZonaUnidad {
  /** Arreglo que representa la fila en la que el jugador 1 juega*/
  private var _areaJuegoJugador1 = ArrayBuffer[Carta]()
  /** Arreglo que representa la fila en la que el jugador 2 juega*/
  private var _areaJuegoJugador2 = ArrayBuffer[Carta]()

  /**Inserta carta en la fila correspondiente
   *
   * Este método toma dos parámetros uno del tipo [[Carta]], y uno del tipo [[IJugador]]. Este método revisa si el
   * jugador ingresado es uno de los dos propietarios de la zona de juego, y usa pattern matching, para definir en que
   * fila se añadirá la carta. En el caso de que el jugador no sea propietario de la zona entonces no hará nada.
   * @param card carta que se va a añadir en su fila correspondiente
   * @param jugador jugador que jugó la carta y defina la fila en la que se añadirá
   */
  override def recibeCartaUnidad(card: Carta, jugador: IJugador): Unit = {
   jugador match {
     case owner1 => _areaJuegoJugador1.addOne(card)
     case owner2 => _areaJuegoJugador2.addOne(card)
   }
  }

  /**Acceso a la fila en la que juega el jugador ingresado
   *
   * Este método toma un parámetro del tipo [[IJugador]], y usa pattern matching para retornar la fila que pertenece al
   * jugador ingresado.
   * @param jugador: Jugador propietario de la fila que queremos mostrar
   * @return el array con la fila de juego correspondiente al jugador ingresado
   */
  override def areaJuego(jugador: IJugador): ArrayBuffer[Carta] = {
    jugador match {
      case owner1 => _areaJuegoJugador1
      case owner2 => _areaJuegoJugador2
    }
  }

}
