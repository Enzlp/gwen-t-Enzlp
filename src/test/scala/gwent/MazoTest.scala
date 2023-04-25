package cl.uchile.dcc
package gwent
import munit.FunSuite
class MazoTest extends FunSuite{
  var deck = new Mazo
  val card1 = new Carta("Escarcha mordiente")
  val card2 = new Carta("Niebla impenetrable")
  val card3 = new Carta("Lluvia torrencial")
  deck.add(card1)
  deck.add(card2)
  deck.add(card3)
  deck.revolver()
  test("Al revolver las cartas del mazo se deben mantener los elementos"){
    var contador = 0

    for(i<-0 until 2){
      var card4 = deck.robar()
      if(card4 ==card1 || card4 ==card2 || card4 ==card3){
        contador+=1
      }
    }
    assertEquals(contador,3)
  }
}
