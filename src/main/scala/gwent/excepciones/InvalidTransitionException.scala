package cl.uchile.dcc
package gwent.excepciones

/**Representa una excepción de transición invalida
 * Esta clase define un tipo excepción que se aplica cuando hay una transición invalida entre estados.
 * @param message Mensaje que se imprime al hacer throw de esta excepción
 */
class InvalidTransitionException(message: String) extends Exception(message)
