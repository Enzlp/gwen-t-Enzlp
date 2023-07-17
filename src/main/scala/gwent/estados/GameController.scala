package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.cartas.Carta
import cl.uchile.dcc.gwent.estados.GameState
import cl.uchile.dcc.gwent.factory.FabricaCartas
import cl.uchile.dcc.gwent.gemObserver.{IGemObserver, Subject, Loser}
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.{ITablero, Tablero}

import scala.io.StdIn.readLine
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.gwent.jugadores.Jugador
class GameController extends IGemObserver[Loser]{
  private var state: GameState = new GameStart(this)
  /**Aquí guardamos la información de nuestros jugadores*/
  private val _jugadores = ArrayBuffer[IJugador]()
  private var _tablero = ArrayBuffer[ITablero]()
  private val cardFactory = new FabricaCartas
  /**Con este arreglo nos encargaremos de ver los turnos de los jugadores.*/
  private var turnosQueue = ArrayBuffer[IJugador]()
  private def generarMazo(): ArrayBuffer[Carta] = {
    var mazo = ArrayBuffer[Carta]()
    
    mazo
  }

  private def addBoard(board: ITablero): Unit = {
    _tablero = _tablero:+ board
  }

  private def addPlayer(player: IJugador, arreglo: ArrayBuffer[IJugador]): Unit ={
    arreglo.addOne(player)
  }

  def setState(state: GameState): Unit ={
    this.state = state
    this.state.setController(this)

  }

  /**Inicializa un Juego nuevo, con jugadores especificados
   *
   * Este método genera el juego, incluyendo jugadores y tablero, en base la información dada por el usuario.
   * Entre
   */

  def startGame(): Unit ={
      val mazo1 = generarMazo()
      val mazo2 = generarMazo()
      println("Escriba el nombre del primer jugador")
      val nombre1: String = readLine()
      println("Escriba el nombre del segundo jugador jugador")
      val nombre2: String = readLine()
      val jugador1 = new Jugador(nombre1, 2, ArrayBuffer[Carta](), mazo1)
      val jugador2 = new Jugador(nombre2, 2, ArrayBuffer[Carta](), mazo2)
      addPlayer(jugador1, _jugadores)
      addPlayer(jugador2, _jugadores)
      addPlayer(jugador1, turnosQueue)
      addPlayer(jugador2, turnosQueue)
      val board = new Tablero(jugador1, jugador2)
      addBoard(board)
      for(jugador<-0 to 1) {
        turnosQueue(jugador).shuffleMazo()
        for (x <- 1 to 10) {
          turnosQueue(jugador).robarCarta()
        }
      }

  }
  def startRound(): Unit ={

  }
  def playCard(jugador: IJugador): Unit = {
    
  }
  def noGems(): Unit ={

  }

  override def update(subject: Subject[Loser], value: Loser): Unit = {
    val loser = value.asInstanceOf[Loser]
    println(s"El juego terminó, el perdedor es: ${loser.name}")
  }

}
