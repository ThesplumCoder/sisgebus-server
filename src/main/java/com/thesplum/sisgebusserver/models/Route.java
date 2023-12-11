package com.thesplum.sisgebusserver.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Route modelas las rutas de autobus que recorren los buses del sistema.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
@Entity
@Table(name = "routes")
public class Route {

  @Id
  private Integer id;

  @Column(name = "name", length = 50)
  private String name;

  @OneToMany(mappedBy = "route")
  private List<Bus> buses;

  @OneToMany(mappedBy = "route")
  private List<BusStand> busStands;

  /**
   * Crea una ruta que tiene unas paradas de autobus asociadas y unos buses
   * haciendo la ruta.
   *
   * @param id        Identificador numérico autogenerado por la BD.
   * @param name      Nombre de la ruta.
   * @param busStands Lista de paradas de autobus que conforman la ruta.
   * @param buses     Lista de buses que hacen la ruta.
   */
  public Route(Integer id, String name, List<BusStand> busStands, List<Bus> buses) {
    setId(id);
    setName(name);
    setBuses(buses);
    setBusStands(busStands);
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
   * Retorna los buses que hacen la ruta.
   *
   * @return Una lista con los buses adscritos a la ruta.
   */
  public List<Bus> getBuses() {
    return buses;
  }

  /**
   * Retorna las paradas de autobus.
   *
   * @return Una lista con las paradas de autobus que conforman la ruta.
   */
  public List<BusStand> getBusStands() {
    return busStands;
  }

  /**
   * Cambia el identificador.
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
   * Cambia la lista de buses que hacen la ruta.
   *
   * @param buses Nueva lista de autobuses que hacen la ruta.
   */
  public void setBuses(List<Bus> buses) {
    if (buses == null) {
      this.buses = new ArrayList<>();
    } else {
      this.buses = new ArrayList<Bus>(buses);
    }
  }

  /**
   * Cambia la lista de paradas de autobus.
   *
   * @param busStands Nueva lista de paradas de autobus que conforman la ruta.
   */
  public void setBusStands(List<BusStand> busStands) {
    if (busStands == null) {
      this.busStands = new LinkedList<>();
    } else {
      this.busStands = new LinkedList<BusStand>(busStands);
    }

  }

  /**
   * Agrega un autobus a la lista de buses que hacen la ruta.
   *
   * @param bus Nuevo autobus.
   * @throws NullPointerException Si el autobus pasada apunta a un valor nulo.
   */
  public void addBus(Bus bus) throws NullPointerException {
    if (bus == null) {
      throw new NullPointerException("The supplied bus is null.");
    }

    buses.add(bus);
  }

  /**
   * Elimina uno de los autobuses de la lista.
   *
   * @param bus Autobus que se desea eliminar.
   * @throws NoSuchElementException Si el autobus a eliminar no existe en la lista
   *                                actual de autobuses.
   * @throws NullPointerException   Si el autobus a eliminar es un valor nulo.
   */
  public void rmBus(Bus bus) throws NoSuchElementException, NullPointerException {
    if (bus == null) {
      throw new NullPointerException("The supplied bus is null.");
    }
    if (!(buses.remove(bus))) {
      throw new NoSuchElementException("The bus doesn't exist.");
    }
  }
}
