package cl.uchile.dcc
package gwent.cartas

import java.util.Objects
abstract class CartaClima(val Nombre:String) extends Carta(Nombre) {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[CartaClima]
  }

  override def equals(that: Any): Boolean = {
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
