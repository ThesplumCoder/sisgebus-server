package com.thesplum.sisgebusserver.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Modela las paradas de autobus.
 *
 * Esta clase permite tener estas paradas de autobus que se pueden reconocer por
 * la dirección física que tienen en la ciudad.
 * 
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
@Entity
@Table(name = "bus_stands")
public class BusStand {

  @Id
  private Integer id;

  @Column(name = "address")
  private String address;

  @ManyToOne
  @JoinColumn(name = "route_id")
  private Route route;

  /**
   * Crea un parada de autobus.
   *
   * @param id      Identificador numérico autogenerado por la BD.
   * @param address Dirección física de la parada de autobus en la ciudad.
   * @param route   Ruta asociada.
   */
  public BusStand(Integer id, String address, Route route) {
    setId(id);
    setAddress(address);
    setRoute(route);
  }

  /**
   * Retorna el id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Retorna la dirección.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Retorna la ruta asociada.
   */
  public Route getRoute() {
    return route;
  }

  /**
   * Cambia el id.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Cambia la dirección.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Cambia la ruta asociada.
   */
  public void setRoute(Route route) {
    this.route = route;
  }
}
