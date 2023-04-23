package cl.uchile.dcc
package gwent

@main
def main(): Unit = {
  println("Hello world!")
}

//implementamos listas para usarlas despues
trait List{
  def add(element: Any)
  def get
}

class carta(var nombre = String)
class mano(var cartas = List)

class mazo(var cartas =List)
class Jugador(var nombre = String, var gemas = Int, var cartas = mano , var mazo = mazo)
