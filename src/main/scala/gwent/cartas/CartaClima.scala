package cl.uchile.dcc
package gwent.cartas

import gwent.Carta
import java.util.Objects
class CartaClima(Nombre:String) extends Carta(Nombre) {
  override def canEqual(that: Any): Unit = {
    that.isInstanceOf[CartaClima]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaClima]
      (this eq other) || (Nombre == other.Nombre)
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[CartaClima], Nombre)
  }


}
