package cl.uchile.dcc
package gwent.tablero

import gwent.tablero.ITablero
import gwent.tablero.ZonaClima

import cl.uchile.dcc.gwent.cartas.{Carta, CartaClima}
import cl.uchile.dcc.gwent.jugadores.IJugador
import cl.uchile.dcc.gwent.tablero.{ZonaCA, ZonaCC, ZonaCD}

import scala.collection.mutable.ArrayBuffer

/**Representa el tablero en el que se jugará
 *
 * Un tablero es un objeto dividido en 4 zonas, una zona de clima, y tres zonas para jugar cartas de unidad cada una
 * subdividida en dos arreglos uno para cada jugador. Entre las zonas de unidad están una zona de carta de combate
 * cuerpo a cuerpo, una zona de combate a distancia y una zona de combate de Asedio.
 * @constructor Crea un nuevo tablero, inicializado para dos jugadores
 * @param jugador1: Uno de los dos jugadores que pueden jugar en este tablero
 * @param jugador2: Uno de los dos jugadores que pueden jugar en este tablero
 */

class Tablero(private val jugador1: IJugador, private val jugador2: IJugador) extends ITablero {
  /** Zona de Clima del tablero */
  private var _zClima = new ZonaClima
  /** Zona de combate de Asedio del tablero contiene las filas para ambos jugadores */
  private var _zCombateCA = new ZonaCA(jugador1, jugador2)
  /** Zona de combate cuerpo a cuerpo del tablero contiene las filas de ambos jugadores */
  private var _zCombateCC = new ZonaCC(jugador1, jugador2)
  /** Zona de combate a distancia del tablero contiene las filas de ambos jugadores */
  private var _zCombateCD = new ZonaCD(jugador1, jugador2)

  /**Juega una carta de Clima
   *
   * Este método, toma una variable del tipo [[Carta]], y lo juega en la zona de Clima del tablero, el tipo de carta
   * jugada es en realidad de tipo [[CartaCLima]], sin embargo esto queda definido mediante double dispatch en la misma
   * clase [[CartaClima]], por ende no es necesario definir el parámetro como [[CartaClima]].
   * Para jugar la carta, se invoca la función recibeCartaClima(card: Carta), de la clase [[ZonaClima]], por lo que usa 
   * double dispatch también
   * @param card: carta a jugar en la zona de Clima
   */
  override def jugarCartaClima(card: Carta): Unit = {
    _zClima.recibeCartaClima(card)
  }

  /**Juega una carta en la zona de combate de asedio en su fila respectiva
   * 
   * Este método, toma dos variables una del tipo [[Carta]], y una del tipo [[IJugador]]. El tipo de la carta en
   * realidad es [[CombateAsedio]], sin embargo queda definido mediante double dispatch en la clase [[CombateAsedio]],
   * que se invoque esta función solo en este tipo de cartas, por lo que no es necesario definirlo en el parámetro.
   * El segundo parámetro, jugador, nos servirá para que la zona identifique en que fila colocar la carta jugada.
   * Para jugar la carta, la zona invoca la función recibeCartaUnidad(carta: Carta, jugador:IJugador), propia de la
   * clase [[ZonaCA]], por lo que sa double dispatch.
   * @param card: carta a jugar en la zona de Combate de Asedio
   * @param jugador: jugador que juega la carta 
   */
  override def jugarCartaCA(card: Carta, jugador: IJugador): Unit = {
    _zCombateCA.recibeCartaUnidad(card, jugador)
  }

  /** Juega una carta en la zona de combate cuerpo a cuerpo en su fila respectiva
   *
   * Este método, toma dos variables una del tipo [[Carta]], y una del tipo [[IJugador]]. El tipo de la carta en
   * realidad es [[CombateCuerpoCuerpo]], sin embargo queda definido mediante double dispatch en la clase 
   * [[CombateCuerpoCuerpo]], que se invoque esta función solo en este tipo de cartas, por lo que no es necesario 
   * definirlo en el parámetro. El segundo parámetro, jugador, nos servirá para que la zona identifique en que 
   * fila colocar la carta jugada. Para jugar la carta, la zona invoca la función 
   * recibeCartaUnidad(carta: Carta, jugador:IJugador), propia de la clase [[ZonaCC]], por lo que sa double dispatch.
   *
   * @param card    : carta a jugar en la zona de Combate cuerpo a cuerpo
   * @param jugador : jugador que juega la carta 
   */
  override def jugarCartaCC(card: Carta, jugador: IJugador): Unit = {
    _zCombateCC.recibeCartaUnidad(card, jugador)
  }

  /** Juega una carta en la zona de combate a distancia en su fila respectiva
   *
   * Este método, toma dos variables una del tipo [[Carta]], y una del tipo [[IJugador]]. El tipo de la carta en
   * realidad es [[CombateDistancia]], sin embargo queda definido mediante double dispatch en la clase 
   * [[CombateDistancia]], que se invoque esta función solo en este tipo de cartas, por lo que no es necesario definirlo
   * en el parámetro. El segundo parámetro, jugador, nos servirá para que la zona identifique en que fila colocar la 
   * carta jugada. Para jugar la carta, la zona invoca la función recibeCartaUnidad(carta: Carta, jugador:IJugador), 
   * propia de la clase [[ZonaCD]], por lo que sa double dispatch.
   *
   * @param card    : carta a jugar en la zona de Combate a distancia
   * @param jugador : jugador que juega la carta 
   */
  override def jugarCartaCD(card: Carta, jugador: IJugador): Unit = {
    _zCombateCD.recibeCartaUnidad(card, jugador)
  }

  /**Método de acceso a la zona de Clima
   * 
   * Este método, muestra una copia deL arreglo que contiene las cartas de la zona de clima, [[_zClima]], del tablero,
   * para poder acceder a sus valores, sin arriesgar que la variable sea manipulado de forma externa. Para esto usa la 
   * función areaJuego propio de la clase [[ZonaClima]], por lo que usa double dispatch.
   * @return: retorna el arreglo copia de la fila en que se juegan las cartas
   */
  override def mostrarZonaClimate: ArrayBuffer[Carta] = {
    val z = _zClima.areaJuego.clone()
    z
  }

  /** Método de acceso a la zona de combate de asedio
   *
   * Este método, muestra una copia deL arreglo que contiene las cartas en zona de combate de asedio, [[_zCombateCA]],
   * del tablero para poder acceder a sus valores, sin arriesgar que la variable sea manipulado de forma externa. 
   * Para esto usa la función areaJuego(jugador: IJugador) propio de la clase [[ZonaCA]], por lo que usa
   * double dispatch. 
   *
   * @return: retorna el arreglo copia de la fila en que se juegan las cartas
   */
  override def mostrarZonaCA(jugador: IJugador): ArrayBuffer[Carta] = {
    _zCombateCA.areaJuego(jugador)
  }

  /** Método de acceso a la zona de combate cuepro a cuerpo
   *
   * Este método, muestra una copia deL arreglo que contiene las cartas en zona de combate cuerpo a cuerpo, 
   * [[_zCombateCC]], del tablero para poder acceder a sus valores, sin arriesgar que la variable sea manipulado de
   * forma externa. Para esto usa la función areaJuego(jugador: IJugador) propio de la clase [[ZonaCC]], por lo que usa
   * double dispatch. 
   *
   * @return: retorna el arreglo copia de la fila en que se juegan las cartas
   */
  override def mostrarZonaCC(jugador: IJugador): ArrayBuffer[Carta] = {
    _zCombateCC.areaJuego(jugador)
  }

  /** Método de acceso a la zona de combate a distancia
   *
   * Este método, muestra una copia deL arreglo que contiene las cartas en zona de combate a distancia, 
   * [[_zCombateCD]], del tablero para poder acceder a sus valores, sin arriesgar que la variable sea manipulado de
   * forma externa. Para esto usa la función areaJuego(jugador: IJugador) propio de la clase [[ZonaCD]], por lo que usa
   * double dispatch. 
   *
   * @return: retorna el arreglo copia de la fila en que se juegan las cartas
   */
  override def mostrarZonaCD(jugador: IJugador): ArrayBuffer[Carta] = {
    _zCombateCD.areaJuego(jugador)
    
  }
}
