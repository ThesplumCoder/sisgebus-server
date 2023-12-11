package com.thesplum.sisgebusserver.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Modela cada posible ayuda que puede prestar un autobus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
@Entity
@Table(name = "helps")
public class Help {

  @Id
  private Integer id;

  @Column(name = "name", length = 50)
  private String name;

  /**
   * Identificador del bus al que pertenece la ayuda.
   */
  @ManyToOne
  @JoinColumn(name = "bus_id")
  private Bus bus;

  /**
   * Crea una ayuda.
   *
   * @param id   Identificador numérico autogenerado por la BD.
   * @param name Nombre de la ayuda.
   * @param bus  Bus asociado.
   */
  public Help(Integer id, String name, Bus bus) {
    setId(id);
    setName(name);
    setBus(bus);
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
   * Retorna el identificador del bus.
   */
  public Bus getBus() {
    return bus;
  }

  /**
   * Cambia el valor del id.
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
   * Cambia el bus al que está relacionada la ayuda.
   */
  public void setBus(Bus bus) {
    this.bus = bus;
  }
}
