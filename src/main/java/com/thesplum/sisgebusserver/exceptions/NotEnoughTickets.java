package com.thesplum.sisgebusserver.exceptions;

/**
 * NotEnoughTickets es la excepción que es usada por el modelo Passenger, para
 * cuando el pasajero no tiene suficientes pasajes de bus para realizar alguna
 * acción.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class NotEnoughTickets extends RuntimeException {

  public NotEnoughTickets() {
    super("Not enough tickets to perform that action.");
  }
}
