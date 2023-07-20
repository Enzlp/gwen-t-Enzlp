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

/**Clase que representa un controlador del juego
 * Esta clase crea un game controller que se encarga de iniciar los estados o etapas del juego. El controlador también
 * es observer de lso sujetos jugadores, que le notifican si se quedan sin gemas.
 * @constructor crea un controlador del juego
 */
class GameController extends IGemObserver[Loser]{
  /** Estado en el que se encuentra el controlador */
  private var state: GameState = new GameStart(this)
  /**Aquí guardamos la información de nuestros jugadores*/
  private val _jugadores = ArrayBuffer[IJugador]()
  /** Aqui hay un registro del tablero actual usado en el juego */
  private var _tablero = ArrayBuffer[ITablero]()
  /** fabrica de cartas para poder generar los mazos */
  private val cardFactory = new FabricaCartas
  /**Con este arreglo nos encargaremos de ver los turnos de los jugadores.*/
  private var turnosQueue = ArrayBuffer[IJugador]()

  /**Método de Acceso al estado del controlador
   * Este método nos deja ver el estado del controlador ya que la variable 'state' es privada
   * @return el estado del controlador
   */
  def estadoActual: GameState = state

  /**Método que genera un mazo de cartas
   * Este método genera un array con cartas de manera aleatoria, usando la fabrica de cartas de tipo [[FabricaCartas]]
   * @return un array con las cartas generadas
   */
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

  /**Método que guarda el tablero en el que se esta jugando
   * Este método es usado para guardar el tablero actual, para poder usarlo después
   * @param board Tablero en el que se esta jugando
   */
  def addBoard(board: ITablero): Unit = {
    _tablero = _tablero:+ board
  }

  /**Método que añade un jugador a la lista de jugadores jugando
   * Este método se usa para añadir un jugador a la lista de jugadores, esto es especialmente útil después para aplicar
   * el método observer
   * @param player
   */
  def addPlayer(player: IJugador): Unit = {
    _jugadores.addOne(player)
  }
  /**Método que cambia el estado del juego
   *
   * Este método cambia el estado del juego por un estado ingresado en el parámetro state de la función, también se
   * encarga de actualizar el controlador en el nuevo estado con la función setController
   * @param state estado al que se quiere pasar
   */
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

  /**Método que inicia una ronda del juego
   * Este método inicia la ronda en el juego, y delega el cambio de estado a la función startRound del state
   */
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

  /**Método de juego de cartas
   * En este método el jugador juega una carta, lo que desencadena un cambio de estado, que es delegado a la función
   * playCard del state
   */
  def playCard(): Unit = {
    state.playCard()
  }

  /**Método que produce un cambio en el estado del controlador al estado final
   * Este cambio genera un cambio de estado, delegado a la función noGems del estado, al estado final del juego.
   */
  def noGems(): Unit ={
    state.noGems()
  }
  /** Método que parte otra ronda si ningun jugador ha perdido despues de llegar al estado endRound
   * Esto lo hace delegando a la función stillGems del estado
   */
  def stillGems(): Unit ={
    state.stillGems()
  }

  /**Método que vuelve aal estado de turno del jugador
   * Este método se invoca cuando uno de los jugadores paso el turno, por lo que al jugar cartas el otro jugador, se
   * mantiene en el estado de turno de ese jugador
   */
  def onlyPlayerLeft(): Unit ={
    state.onlyPlayerLeft()
  }

  /**Método define pasar el turno por parte de un jugador
   * Este método produce un cambio de estado al estado de turno del otro jugador, además elimina al jugador que pasó
   * el turno de la cola de turnos así el siguiente jugador juegue solo hasta que pase el turno.
   * @param jugador jugador que paso el turno
   */
  def passTurn(jugador: IJugador): Unit ={
    turnosQueue -= jugador
    state.passTurn()    
  }

  /**Método que termia la ronda de juego
   * Este método termina la ronda del juego y produce un cambio en el estado del controlador, esto es delegado al
   * estado state del controlador
   */
  def endRound(): Unit ={
    state.endRound()
  }

  /**Método que termina el juego cuando un jugador se queda sin gemas
   * Este método es parte del observer pattern, y cuando el jugador notifica al controlador que perdió se toma como
   * parametro un objeto del tipo Loser, que contiene adentro el atributo del nombre del perdedor, este se imprime
   * en la pantalla y se transiciona al estado final con la función noGems()
   * @param subject sujeto que es observado en este caso un jugador
   * @param value objeto recibido en este caso un objeto del tipo Loser con el nombre del perdedor
   */
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
