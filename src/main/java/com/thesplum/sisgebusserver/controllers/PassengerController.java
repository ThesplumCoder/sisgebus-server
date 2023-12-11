package com.thesplum.sisgebusserver.controllers;

import java.util.List;
import java.util.LinkedList;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.thesplum.sisgebusserver.models.Passenger;
import com.thesplum.sisgebusserver.repositories.PassengerRepository;

/**
 * Controlador de peticiones para el modelo de Pasajero.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/passenger")
public class PassengerController {

  @Autowired
  private PassengerRepository passengerRepo;

  @GetMapping()
  public List<Passenger> getAll() {
    LinkedList<Passenger> res = new LinkedList<>();
    for (Passenger passenger : passengerRepo.findAll()) {
      res.add(passenger);
    }
    return res;
  }

  @PostMapping()
  public Passenger addPassenger(@Valid @RequestBody Passenger passenger) {
    return passengerRepo.save(passenger);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody Passenger passenger) {
    passengerRepo.deleteById(passenger.getId());
  }
}
