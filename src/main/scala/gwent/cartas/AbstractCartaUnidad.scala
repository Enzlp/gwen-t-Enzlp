package cl.uchile.dcc
package gwent.cartas

import java.util.Objects
abstract class AbstractCartaUnidad(val Nombre:String) extends AbstractCarta(Nombre){
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AbstractCartaUnidad]
  }
  override def equals(that:Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractCartaUnidad]
      (this eq other) || (Nombre == other.Nombre)
    } else {
      false
    }
  } 
  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractCartaUnidad], Nombre)
  }
}
