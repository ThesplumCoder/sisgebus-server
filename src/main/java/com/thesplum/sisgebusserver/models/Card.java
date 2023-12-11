package com.thesplum.sisgebusserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Card modela las tarjetas de acceso que se utilizan para las registradoras que
 * están en las diferentes estaciones del STM; además, estas tarjetas también se
 * usan para pagar el pasaje de los buses.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
@Entity
@Table(name = "cards")
public class Card {

  @Id
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "passenger_id")
  private Passenger passenger;

  /**
   * Incializa una tarjeta del STM.
   */
  public Card(Integer id, Passenger passenger) {
  }

  /**
   * Retorna el id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Retorna el pasajero asociado.
   */
  public Passenger getPassenger() {
    return passenger;
  }

  /**
   * Cambia el id.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Cambia el pasajero asociado.
   */
  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }
}
