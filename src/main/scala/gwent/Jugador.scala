package cl.uchile.dcc
package gwent

import gwent.IJugador
import gwent.cartas.Carta
import scala.Equals
import scala.collection.mutable.ArrayBuffer
import scala.util.Random as rand

class Jugador (val nombre: String, var gemas : Int, private var _mano : ArrayBuffer[Carta]
               ,private var _mazo: ArrayBuffer[Carta]) extends IJugador {
  override def mano: ArrayBuffer[Carta] = _mano

  override def mazo: ArrayBuffer[Carta] = _mazo

  override def robarCarta(): Carta = {
    val card = mazo.last;
    mano.addOne(card);
    mazo.dropRight(1);
    card
  }

  override def shuffleMazo(): Unit ={
    _mazo = rand.shuffle(mazo)
  }


}
