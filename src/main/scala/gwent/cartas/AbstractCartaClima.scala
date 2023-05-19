package cl.uchile.dcc
package gwent.cartas

import java.util.Objects
abstract class AbstractCartaClima(val Nombre:String) extends AbstractCarta(Nombre) {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AbstractCartaClima]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractCartaClima]
      (this eq other) || (Nombre == other.Nombre)
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractCartaClima], Nombre)
  }


}
