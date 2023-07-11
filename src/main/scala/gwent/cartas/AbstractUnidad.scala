package cl.uchile.dcc
package gwent.cartas

/**Clase abstracta que representa el tipo general de una carta de Unidad
 * 
 * Un AbstractUnidad del tipo [[Carta]] , es una carta que tiene asociado un nombre, una descripción y un poder propio.
 * Además la clase AbstractUnidad declara una variable llamada poderActual, que muestra el poder actual de la carta después
 * de aplicarle los efectos de las demás cartas.
 *
 * @constructor Crea una nueva ´AbstractUnidad´, con descripcion, nombre y poder.
 * @param nombre : El nombre de la carta, identificador de la carta
 * @param descripcion: Breve descripcion de el funcionamiento de la carta, sus habilidades y efecto en el campo de batalla
 * @param poder: valor del poder o fuerza de la carta
 */
abstract class AbstractUnidad(nombre: String, descripcion: String, val poder: Int) extends AbstractCarta(nombre, descripcion) {
  /** Poder De la carta después de aplicarle los efectos de las demás cartas,
   * parte siendo igual al [[poder]] propio de la carta original.
   */
  private var _poderActual: Int = poder

  /** Método de acceso al valor del poder actual de la carta de unidad
   * Este método nos permite acceder al valor del poder actual de la carta
   * Es un Getter
   *
   * @return EL poder actual 
   */
  def poderActual: Int = _poderActual
  
}
