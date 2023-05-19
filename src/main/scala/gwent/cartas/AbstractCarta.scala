package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

abstract class Carta (val nombre: String ) extends ICarta {
  override def equals(that:Any) : Boolean ={
    if (canEqual(that)){
      val other = that.asInstanceOf[Carta]
      (this eq other)||(nombre == other.nombre )
    }
    else{
      false
    }
  }


}

