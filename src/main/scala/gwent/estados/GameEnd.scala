package cl.uchile.dcc
package gwent.estados

import cl.uchile.dcc.gwent.estados.GameController

/**Clase que representa el estado GameEnd del controlador
 * Este es el estado final del controlador, y extiende de GameState, por ende posee una variable controller del tipo
 * [[GameController]], que es el controlador asociado al estado
 * @param controller controlador asociado al estado
 */
class GameEnd(controller: GameController) extends GameState(controller){


}
