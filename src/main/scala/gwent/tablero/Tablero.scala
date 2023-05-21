package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.AbstractTablero
import scala.collection.mutable.ArrayBuffer
import gwent.cartas.Carta

class Tablero extends AbstractTablero { 
  override def jugarCarta(card: Carta) ={
    zonaClima.addOne(card)
  }
}
