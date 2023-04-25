package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Mazo extends Mano{
  private var largo: Int = 25
  private var mazo = new ArrayBuffer[Carta]()
  

  def robar(): Carta = {
    var card = mazo(largo)
    mazo.remove(25)
    largo -= 1
    return card
  }
  def revolver(): Any = {
    Random.shuffle(mazo)
  }
}
