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

import com.thesplum.sisgebusserver.models.Bus;
import com.thesplum.sisgebusserver.repositories.BusRepository;

/**
 * Controlador de peticiones para el modelo de autobus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bus")
public class BusController {

  @Autowired
  private BusRepository busRepo;

  @GetMapping()
  public List<Bus> getAll() {
    LinkedList<Bus> res = new LinkedList<>();
    for (Bus bus : busRepo.findAll()) {
      res.add(bus);
    }
    return res;
  }

  @PostMapping()
  public Bus createGuest(@Valid @RequestBody Bus bus) {
    return busRepo.save(bus);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody Bus bus) {
    busRepo.deleteById(bus.getId());
  }
}
