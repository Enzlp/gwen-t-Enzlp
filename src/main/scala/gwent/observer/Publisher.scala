package cl.uchile.dcc
package gwent.observer

import cl.uchile.dcc.gwent.estados.GameController
import cl.uchile.dcc.gwent.jugadores.IJugador
class Publisher(private var controller: GameController) {
    private var _jugadores =  List[IJugador]()
    def addPlayer(player: IJugador): Unit ={
      _jugadores = _jugadores :+ player
    }
    def updateNoGems(): Unit ={
      controller.noGems()
    }
}

