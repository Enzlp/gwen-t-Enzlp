package cl.uchile.dcc
package gwent

class Jugador (val nombre: String, var gemas : Int ){
  private var mano = new Mano
  private var mazo = new Mazo
  def robar():Any = {
    var card = mazo.robar()
    mano.add(card)
    
  }
  
}
