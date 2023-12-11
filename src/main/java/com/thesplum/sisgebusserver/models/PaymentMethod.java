package com.thesplum.sisgebusserver.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * PaymentMethod modela cada uno de los métodos de pago que soporta el sistema
 * para la compra de pasajes de bus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

  @Id
  private Integer id;

  @Column(name = "name", length = 15, nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "passenger_id")
  private Passenger passenger;

  @Column(name = "status", length = 15, nullable = false)
  private String status;

  /**
   * Crea un método de pago que tiene un identificador, y además posee un nombre
   * de uso común que lo identifica.
   *
   * @param id        Identificador numérico autogenerado por la BD.
   * @param name      Nombre del método de pago.
   * @param passenger Pasajero asociado.
   * @param status    Estado del método de pago.
   */
  public PaymentMethod(Integer id, String name, Passenger passenger, String status) throws NullPointerException {
    setId(id);
    setName(name);
    setPassenger(passenger);
    setStatus(status);
  }

  /**
   * Retorna el id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Retorna el nombre.
   */
  public String getName() {
    return name;
  }

  /**
   * Retorna el pasajero asociado.
   */
  public Passenger getPassenger() {
    return passenger;
  }

  /**
   * Retorna el estado.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Cambia el id.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Cambia el nombre.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Cambia el pasajero asociado.
   */
  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  /**
   * Cambia el estado.
   *
   * @param status Nuevo estado para el método de pago.
   */
  public void setStatus(String status) {
    if (status == null) {
      throw new NullPointerException("The status can't be null.");
    }

    this.status = status;
  }
}
