package com.thesplum.sisgebusserver.models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Bus modela los autobuses que soportan la operación de transporte de personas
 * en el STM.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
@Entity
@Table(name = "buses")
public class Bus {

  @Id
  private Integer id;

  @Column(name = "classification", length = 15)
  private String classification;
  /**
   * Es el identificador de la última parada de autobus en la que estuvo. Con esto
   * podemos aproximar la ubicación real del mismo.
   */
  @OneToOne
  @JoinColumn(name = "location_id")
  private BusStand location;

  @ManyToOne
  @JoinColumn(name = "route_id")
  private Route route;

  @Column(name = "license_plate", length = 10)
  private String licensePlate;

  @OneToMany(mappedBy = "bus")
  private List<Help> helps;

  /**
   * Crea un bus que tiene identificador, placa de tránsito, clasificación,
   * localización y ayudas para gente con discapacidad.
   *
   * @param id             Identificador numérico autogenerado por la BD.
   * @param classification Clasificación del bus.
   * @param location       Última parada visitada por el autobus.
   * @param route          Identificador numérico autogenerado por la BD para la
   *                       ruta.
   * @param licensePlate   Placa de tránsito.
   * @param helps          Soportes o ayudas para gente con discapacidad.
   * @throws IllegalArgumentException Si ocurrió un error en la asignación de
   *                                  atributos.
   * @throws NullPointerException     Si ocurrió un error en la asignación de
   *                                  atributos o en el constructor de Entity.
   */
  public Bus(Integer id, String classification, BusStand location, Route route, String licensePlate,
      List<Help> helps) throws IllegalArgumentException, NullPointerException {

    setId(id);
    setClassification(classification);
    setLocation(location);
    setRoute(route);
    setLicensePlate(licensePlate);
    setHelps(helps);
  }

  /**
   * Retorna el id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Retorna la clasificación del bus.
   *
   * @return Constante que representa la clasificación.
   */
  public String getClassification() {
    return classification;
  }

  /**
   * Retorna el identificador de la última parada de autobus en la que estuvo.
   *
   * @return Identificador de parada de autobus de última vez.
   */
  public BusStand getLocation() {
    return location;
  }

  /**
   * Retorna el identificador de la ruta que está haciendo el bus.
   *
   * @return Identificador de la ruta.
   */
  public Route getRoute() {
    return route;
  }

  /**
   * Retorna la placa de tránsito que tiene el bus.
   *
   * @return Cadena con la placa de tránsito.
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  /**
   * Retorna todas las ayudas que posee el bus.
   *
   * @return Lista de ayudas, cada una es una ayuda que posee el bus.
   */
  public List<Help> getHelps() {
    return helps;
  }

  /**
   * Cambia el identificador.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Cambia la clasificación del bus.
   *
   * @param classification Nuevo clasificación del bus.
   * @throws NullPointerException Si la clasificación del bus es un valor nulo.
   */
  public void setClassification(String classification) throws NullPointerException {
    if (classification == null) {
      throw new NullPointerException("The classification can't be null.");
    }
    this.classification = classification;
  }

  /**
   * Cambia el identificador de la última parada visitada del autobus.
   *
   * @param location Identificador de la última parada de autobus en la que
   *                 estuvo el autobus.
   * @throws NullPointerException Si el identificador de parada de autobus pasado
   *                              es un valor nulo.
   */
  public void setLocation(BusStand location) throws NullPointerException {
    if (location == null) {
      throw new NullPointerException("The location is null.");
    }
    this.location = location;
  }

  /**
   * Cambia el identificador de la ruta del autobus.
   *
   * @param route Identificador de la ruta de autobus.
   * @throws NullPointerException Si el identificador la ruta pasado es un valor
   *                              nulo.
   */
  public void setRoute(Route route) throws NullPointerException {
    if (route == null) {
      throw new NullPointerException("The route is null.");
    }
    this.route = route;
  }

  /**
   * Cambia la placa de tránsito.
   *
   * @param licensePlate Nueva placa de tránsito.
   * @throws IllegalArgumentException Si la placa de tránsito está vacía o solo
   *                                  contiene espacios en blanco.
   * @throws NullPointerException     Si la placa de tránsito apunta a un valor
   *                                  nulo.
   */
  public void setLicensePlate(String licensePlate) throws IllegalArgumentException, NullPointerException {
    if (licensePlate == null) {
      throw new NullPointerException("The supplied license plate is null.");
    }
    if (licensePlate.isBlank()) {
      throw new IllegalArgumentException("The license plate can't be empty.");
    }

    this.licensePlate = licensePlate;
  }

  /**
   * Cambia la lista de ayudas que tiene el autobus.
   *
   * Si se pasa un valor nulo se entenderá que el bus por el momento no posee
   * ninguna ayuda, y se inicializa una lista vacía.
   *
   * @param helps Una lista con las nuevas ayudas que posee el bus, cada una
   *              como un texto.
   */
  public void setHelps(List<Help> helps) {
    if (helps == null) {
      this.helps = new ArrayList<>();
    } else {
      this.helps = new ArrayList<>(helps);
    }
  }

  /**
   * Agrega una ayuda para gente discapacitada.
   *
   * @param help Nueva ayuda que se agregó.
   * @throws NullPointerException Si la ayuda a agregar es un valor nulo.
   */
  public void addHelp(Help help) throws NullPointerException {
    if (help == null) {
      throw new NullPointerException("The supplied help is null.");
    }
    helps.add(help);
  }

  /**
   * Elimina una de las ayudas que posea el autobus.
   *
   * @param help Ayuda que se desea eliminar.
   * @throws NoSuchElementException Si la ayuda a eliminar no existe en la lista
   *                                actual de ayudas.
   * @throws NullPointerException   Si la ayuda a eliminar es un valor nulo.
   */
  public void rmHelp(Help help) throws NoSuchElementException, NullPointerException {
    if (help == null) {
      throw new NullPointerException("The supplied help is null.");
    }
    if (!(helps.remove(help))) {
      throw new NoSuchElementException("The help doesn't exist.");
    }
  }
}
