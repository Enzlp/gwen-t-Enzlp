package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.{AbstractCartaUnidad, ICarta}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import gwent.cartas.AbstractCartaUnidad
import gwent.cartas.AbstractCartaClima
class Jugador (val nombre: String, var gemas : Int ) extends IJugador {
  private var mano = ArrayBuffer[ICarta]()
  private var mazo = ArrayBuffer[ICarta]()

  override def generarMazo(): Any = {

    for(i<-1 to 18){
      var cardC = new AbstractCartaClima("Clima")
      mazo.addOne(cardC);
    }
    for(i<-1 to 7){
      var cardU = new AbstractCartaUnidad("Unidad")
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
