package cl.uchile.dcc
package gwent.cartas

import gwent.Carta
import java.util.Objects
class CartaUnidad(Nombre:String) extends Carta(Nombre){
  override def canEqual(that: Any): Unit = {
    that.isInstanceOf[CartaUnidad]
  }
  override def equals(obj:Any): Boolean = {
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
