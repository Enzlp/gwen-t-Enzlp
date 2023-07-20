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

  def estadoActual: GameState = state
  private def generarMazo(): ArrayBuffer[Carta] = {
    var mazo :ArrayBuffer[Carta] = ArrayBuffer[Carta]()
    for(i<-1 to 2){
      mazo = mazo :+ cardFactory.createNieblaImpenetrable
      mazo = mazo :+ cardFactory.createLluviaTorrencial
      mazo = mazo :+ cardFactory.createEscarchaMordiente
    }
    mazo = mazo:+ cardFactory.createClimaDespejado
    for(i<-1 to 3) {
      mazo = mazo :+ cardFactory.createCloseCombat(false, false)
      mazo = mazo :+ cardFactory.createRangeCombat(false, false)
      mazo = mazo :+ cardFactory.createSiegeCombat(false, false)
    }
    for(i<-1 to 2){
      mazo = mazo :+ cardFactory.createCloseCombat(true, false)
      mazo = mazo :+ cardFactory.createRangeCombat(true, false)
      mazo = mazo :+ cardFactory.createSiegeCombat(true, false)
    }
    mazo = mazo :+ cardFactory.createCloseCombat(false, true)
    mazo = mazo :+ cardFactory.createRangeCombat(false, true)
    mazo = mazo :+ cardFactory.createSiegeCombat(false, true)

    mazo
  }

  def addBoard(board: ITablero): Unit = {
    _tablero = _tablero:+ board
  }

  def addPlayer(player: IJugador): Unit ={
    _jugadores.addOne(player)
  }

  def setState(state: GameState): Unit ={
    this.state = state
    this.state.setController(this)

  }

  /**Inicializa un Juego nuevo, con jugadores especificados
   *
   * Este método genera el juego, incluyendo jugadores y tablero, en base la información dada en este caso tomaremos
   * que la información ya fue proveida, al terminar de inicializar las condiciones iniciales del tablero, incova la
   * función startGame del state para cambiar el estado en el juego.
   */

  def startGame(): Unit ={
      val mazo1: ArrayBuffer[Carta] = generarMazo()
      val mazo2: ArrayBuffer[Carta] = generarMazo()
      val nombreJugador1 = "jugador1"
      val nombreJugador2: String = "jugador2"
      val jugador1 = new Jugador(nombreJugador1, 2, ArrayBuffer[Carta](), mazo1)
      val jugador2 = new Jugador(nombreJugador2, 2, ArrayBuffer[Carta](), mazo2)
      addPlayer(jugador1)
      addPlayer(jugador2)
      turnosQueue=turnosQueue:+ jugador1
      turnosQueue = turnosQueue:+ jugador2
      val board = new Tablero(jugador1, jugador2)
      addBoard(board)
      for(jugador<-0 to 1) {
        turnosQueue(jugador).shuffleMazo()
        for (x <- 1 to 10) {
          turnosQueue(jugador).robarCarta()
        }
      }
      state.startGame(_jugadores)
  }
  def startRound(): Unit ={
    for(jugador<-turnosQueue){
      if(jugador.mano.length < 10){
        var x = 3
        while(x > 0 && jugador.mano.length<10){
          jugador.robarCarta()
          x+=1
        }
      }
    }
    state.startRound()
  }
  def playCard(): Unit = {
    state.playCard()
  }
  def noGems(): Unit ={
    state.noGems()
  }
  def stillGems(): Unit ={
    state.stillGems()
  }
  def onlyPlayerLeft(): Unit ={
    state.onlyPlayerLeft()
  }
  def passTurn(jugador: IJugador): Unit ={
    turnosQueue -= jugador
    state.passTurn()    
  }
  def endRound(): Unit ={
    state.endRound()
  }

  override def update(subject: Subject[Loser], value: Loser): Unit = {
    val loser = value.asInstanceOf[Loser]
    println(s"El juego terminó, el perdedor es: ${loser.name}")
    noGems()
  }

  /**Función deja cambiar el estado actual solo si se sabe la contraseña
   *
   * Este método usa un parámetro de tipo string para definir una contraseña con la cual se puede cambiar el estado del
   * controlador, sin tener que pasar por la progresión normal, esto es útil para los tests de los métodos que generan
   * cambios de estado
   * @param password: Contraseña que necesita para invocar la función
   * @param state estado al que se quiere pasar
   */
  def masterSetState(password: String, state: GameState) ={
    val validPassword = "126$" 
    if(password == validPassword){
      setState(state)
    }
  }

}
