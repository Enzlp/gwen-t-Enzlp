package cl.uchile.dcc
package gwent

import gwent.ICarta

import cl.uchile.dcc.gwent.cartas.CartaUnidad

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import gwent.cartas.CartaUnidad
import gwent.cartas.CartaClima
class Jugador (val nombre: String, var gemas : Int ) extends IJugador {
  private var mano = ArrayBuffer[ICarta]()
  private var mazo = ArrayBuffer[ICarta]()

  override def GenerarMazo(): Any = {

    for(i<-1 to 18){
      var cardC = new CartaClima("Clima")
      mazo.addOne(cardC);
    }
    for(i<-1 to 7){
      var cardU = new CartaUnidad("Unidad")
      mazo.addOne(cardU);
    }
    Random.shuffle(mazo);

  }

  override def robar():Any = {
    var card = mazo.last;
    mano.addOne(card);
    mazo.dropRight(1);

  }

  override def LLenarMano(): Any = {
    for(i <-1 to 10){
      var card = mazo.last
      mano.addOne(card);
      mazo.dropRight(1);
    }
  }

  override def mostrarMano(): ArrayBuffer[ICarta] = {
    mano
  }


}
