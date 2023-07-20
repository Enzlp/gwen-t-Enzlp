package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.cartas.Carta

/**Clase abstracta
 * Representa el esqueleto de las funciones que debería tener un visitor que aplique efectos de cartas de unidad con
 * vínculo estrecho o refuerzo moral. Todos los métodos del visitor están definidos como vacíos y luego en las clases
 * concretas se definirán lo que hará cada uno dependiendo del tipo de visitor. También posee una variable con la carta 
 * jugada, y un método que permite almacenar esta en el arreglo
 */
class AbstractUnitEffects extends Visitor {
  /** Este arreglo contiene la carta jugada que desencadenará el efecto, luego se usará para poder obtener su nombre*/
  var _cartaJugada: ArrayBuffer[Carta] = ArrayBuffer()

  /**Método que permite almacenar la carta jugada en el arreglo
   * 
   * Este método nos deja guardar la carta jugada que desencadeno el efecto correspondiente, el parámetro card es la
   * carta jugada. Se usa la función clear porque solo puede ser almacenada una carta a la vez para facilitar la
   * obtención del nombre para aplicar vínculo Estrecho
   * @param card carta Jugada
   */
  def cartaJugada(card: Carta): Unit = {
    _cartaJugada.clear()
    _cartaJugada = _cartaJugada :+ card
  }
  override def visitCombateCA(ca: CombateAsedio): Unit = {/*...*/}
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {/*...*/}
  override def visitCombateCD(cd: CombateDistancia): Unit = {/*...*/}
}
