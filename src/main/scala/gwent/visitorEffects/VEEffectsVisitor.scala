package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

import cl.uchile.dcc.gwent.visitorEffects.AbstractUnitEffects
class VEEffectsVisitor extends AbstractUnitEffects {
  override def visitCombateCA(ca: CombateAsedio): Unit = {
    if (ca.nombre == _cartaJugada(0).nombre) {
      ca.cambiarPoderActual(2 * ca.poderActual)
    }
  }

  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {
    if(cc.nombre == _cartaJugada(0).nombre){
      cc.cambiarPoderActual(2*cc.poderActual)
    }
  }
  override def visitCombateCD(cd: CombateDistancia): Unit ={
    if(cd.nombre == _cartaJugada(0).nombre){
      cd.cambiarPoderActual(2*cd.poderActual)
    }
  }
}
