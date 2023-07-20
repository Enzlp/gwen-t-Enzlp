package cl.uchile.dcc
package gwent.gemObserver

/**Clase Abstracta 
 * Representa la estructura básica que debe tener un Subject para poder ser observado por un Observer. Como es una 
 * clase abstracta, esta clase no existe por lo que no se puede instanciar (no se pueden hacer referencias a esta clase
 * o crear un objeto en base a esta) 
 * @tparam T Acepta un parámetro cualquiera, representa el Subject
 */
abstract class AbstractSubject[T] extends Subject[T] {
  /** Lista con los observers que se suscriben a ver los cambios los subjects*/
  private var observers: List[IGemObserver[T]] = Nil

  /**Función de acceso a la lista de observers
   * Esta función crea una copia de la lista de observers y lo retorna, así evita que se pueda manipular la variable 
   * 'observers' por externos. 
   * @return lista con los observers que se suscriben a los cambios del subject
   */
  override def showObservers: List[IGemObserver[T]] = {
    val _showObservers = observers
    _showObservers
  }

  /**Función que añade un observer a la lista de Observers
   * Esta función toma un parámetro de tipo [[IGemObserver]], que se añade a la lista de observers usando el operador
   * '::'.
   * @param observer observer que se va a añadir a la lista de observadores
   */
  override def addObserver(observer: IGemObserver[T]): Unit = {
    observers = observer :: observers
  }
  /** Función que notifica a los observers de un cambio en la información del Subject 
   * Esta función usa un for loop para aplicar a cada observer la función update(), esta función se encargará de el
   * cambio en el observer, esta toma un parámetro de un tipo genérico T que pasara al observer mediante la función 
   * update()
   * @param value objeto que se pasará al observer 
   */
  override def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }
}
