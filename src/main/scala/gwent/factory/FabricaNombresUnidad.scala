package cl.uchile.dcc
package gwent.factory

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**Representa un objeto FabricaNombreUnidad
 * La clase FabricaNombreUnidad, se implementa mediante el patron de diseño Factory pattern. Por lo tanto, es un objeto,
 * que genera nombres usando un método generateName
 * @constructor Crea un objeto FabricaNombresUnidad
 */
class FabricaNombresUnidad {
  /** las variables n1 a n8 son los nombres para cartas */
  private val n1 = "Keltullis"
  private val n2 = "Conde Kaldwell"
  private val n3 = "Espíritu del Bosque"
  private val n4 = "Príncipe Villem"
  private val n5 = "Babagor"
  private val n6 = "Caballería Lyria"
  private val n7 = "Falibon"
  private val n8 = "Gascon"
  /** Array con los nombres de las cartas */
  private val nombres: ArrayBuffer[String] = ArrayBuffer(n1,n2,n3,n4,n5,n6,n7,n8)

  /**Genera nombre de forma aleatoria
   *  Método que elige un nombre de manera aleatoria del arreglo con nombres, usando Random.between(),  y lo retorna
   * @return nombre generado
   */
  def generateName: String = nombres(Random.between(0,8))
}
