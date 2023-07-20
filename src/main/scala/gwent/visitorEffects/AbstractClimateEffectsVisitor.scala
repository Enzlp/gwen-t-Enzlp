package cl.uchile.dcc
package gwent.visitorEffects
import gwent.cartas.clases.{CombateAsedio, CombateCuerpoCuerpo, CombateDistancia}

/**clase abstracta
 * Representa el esqueleto de las funciones que debería tener un visitor que aplique efectos de cartas de clima. Todos
 * los métodos están definidos como vacíos y luego en las clases concretas se definirán lo que hará cada uno dependiendo
 * del tipo de visitor
 */
abstract class AbstractClimateEffectsVisitor extends Visitor {
  override def visitCombateCA(ca: CombateAsedio): Unit = {/*...*/}
  override def visitCombateCC(cc: CombateCuerpoCuerpo): Unit = {/*...*/}
  override def visitCombateCD(cd: CombateDistancia): Unit = {/*...*/}
}
