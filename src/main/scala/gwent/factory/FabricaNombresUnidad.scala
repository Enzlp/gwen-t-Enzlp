package cl.uchile.dcc
package gwent.factory

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
class FabricaNombresUnidad {
  private val n1 = "Keltullis"
  private val n2 = "Conde Kaldwell"
  private val n3 = "Espíritu del Bosque"
  private val n4 = "Príncipe Villem"
  private val n5 = "Babagor"
  private val n6 = "Caballería Lyria"
  private val n7 = "Falibon"
  private val n8 = "Gascon"
  private val nombres: ArrayBuffer[String] = ArrayBuffer()
  
  def generateName: String = nombres(Random.between(0,8))
}
