package cl.uchile.dcc
package gwent.cartas

import java.util.Objects
abstract class CartaUnidad(val Nombre:String) extends Carta(Nombre){
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[CartaUnidad]
  }
  override def equals(that:Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaUnidad]
      (this eq other) || (Nombre == other.Nombre)
    } else {
      false
    }
  } 
  override def hashCode(): Int = {
    Objects.hash(classOf[CartaUnidad], Nombre)
  }
}
