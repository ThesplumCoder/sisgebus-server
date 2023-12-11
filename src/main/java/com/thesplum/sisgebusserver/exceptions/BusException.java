package exceptions;

/**
 * Esta clase me permite lanzar la excepción causada por un mal manejo de la
 * clase que modela la entidad "Bus".
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public class BusException extends Exception {

  public BusException(String message) {
    super(message);
  }
}
