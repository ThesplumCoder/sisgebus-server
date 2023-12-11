package com.thesplum.sisgebusserver.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.thesplum.sisgebusserver.exceptions.NotEnoughTickets;

/**
 * Passenger modela los usuarios que utilizan el sistema.
 *
 * Esta clase permite identificar a cada usuario, y le permite realizar
 * operaciones de gestión de su transporte.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
@Entity
@Table(name = "passengers")
public class Passenger {

  @Id
  private Integer id;

  @Column(name = "name", length = 80, nullable = false)
  private String name;

  @Column(name = "bus_tickets")
  private int busTickets;

  @OneToMany(mappedBy = "passenger")
  private List<Card> cards;

  @OneToMany(mappedBy = "passenger")
  private List<PaymentMethod> paymentMethods;

  /**
   * Crea un usuario con todos los parámetros definidos externamente.
   *
   * @param id             Identificador numérico autogenerado por la BD.
   * @param name           Nombre del usuario.
   * @param busTickets     Cantidad de pasajes de bus.
   * @param cards          Tarjetas de bus.
   * @param paymentMethods Métodos de pago que tenga el usuario registrados.
   */
  public Passenger(Integer id, String name, int busTickets, List<Card> cards, List<PaymentMethod> paymentMethods)
      throws IllegalArgumentException {
    setId(id);
    setName(name);
    setBusTickets(busTickets);
    setCards(cards);
    setPaymentMethods(paymentMethods);
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
   * Retorna la cantidad de pasajes de bus que tiene el pasajero.
   *
   * @return Número de la cantidad de pasajes.
   */
  public int getBusTickets() {
    return busTickets;
  }

  /**
   * Retorna las tarjetas de bus que posee el pasajero.
   * 
   * @return Lista de tarjetas de bus. Si no tiene ninguna se retornará una lista
   *         vacía.
   */
  public List<Card> getCards() {
    return cards;
  }

  /**
   * Retorna los métodos de pago que tiene registrados.
   *
   * @return Lista de métodos de pago. Si no tiene ninguno se retornará una lista
   *         vacía.
   */
  public List<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
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
   * Cambia la cantidad de tiquetes de bus.
   *
   * @param busTickets Nueva cantidad de tiquetes de bus.
   * @throws IllegalArgumentException Si la cantidad de tiquetes de autobus es
   *                                  menor que cero.
   */
  public void setBusTickets(int busTickets) throws IllegalArgumentException {
    if (busTickets < 0) {
      throw new IllegalArgumentException("The amount of tickets can't be negative.");
    }
    this.busTickets = busTickets;
  }

  /**
   * Cambia la lista de tarjetas de bus que tiene el pasajero.
   *
   * Si se pasa un valor nulo se acepta y se entiende que el pasajero ahora no
   * posee tarjetas.
   * 
   * @param cards Lista de tarjetas de bus que se desea dar al pasajero.
   */
  public void setCards(List<Card> cards) {
    if (cards == null) {
      this.cards = new ArrayList<>();
    } else {
      this.cards = cards;
    }
  }

  /**
   * Cambia la lista de métodos de pago.
   *
   * Si se pasa un valor nulo se entiende que el pasajero por el momento no tiene
   * ningún método de pago.
   * 
   * @param paymentMethods Lista de métodos de pago que tiene el pasajero.
   */
  public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
    if (paymentMethods == null) {
      this.paymentMethods = new ArrayList<>();
    } else {
      this.paymentMethods = paymentMethods;
    }
  }

  /**
   * Adiciona un pasaje de bus a la cantidad actual de pasajes.
   */
  public void addTicket() {
    busTickets += 1;
  }

  /**
   * Quita un pasaje de bus a la cantidad actual de pasajes.
   *
   * @throws NotEnoughTickets Si la cantidad de pasajes es igual a cero y se
   *                          invoca este método.
   */
  public void rmTicket() throws NotEnoughTickets {
    if (busTickets == 0) {
      throw new NotEnoughTickets();
    }

    busTickets -= 1;
  }

}
