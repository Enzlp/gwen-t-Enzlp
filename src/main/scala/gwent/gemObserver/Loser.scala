package cl.uchile.dcc
package gwent.gemObserver

/**Representa un objeto de tipo [[Loser]]
 * Esta clase se usa para poder identificar al perdedor del juego. Esto debido a que un objeto es más fácil de mandar, 
 * a través de funciones con double dispatch. 
 * @constructor Crea un objeto con nombre 
 * @param name nombre del jugador que pierde
 */
class Loser(val name: String){

}
