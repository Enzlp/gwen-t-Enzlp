package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

abstract class AbstractCarta(val nombre: String ) extends ICarta {
  override def equals(that:Any) : Boolean ={
    if (canEqual(that)){
      val other = that.asInstanceOf[AbstractCarta]
      (this eq other)||(nombre == other.nombre )
    }
    else{
      false
    }
  }


}

