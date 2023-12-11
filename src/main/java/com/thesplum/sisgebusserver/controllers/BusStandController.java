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

import com.thesplum.sisgebusserver.models.BusStand;
import com.thesplum.sisgebusserver.repositories.BusStandRepository;

/**
 * Controlador de peticiones para el modelo de paradas de autobus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bus-stand")
public class BusStandController {

  @Autowired
  private BusStandRepository busStandRepo;

  @GetMapping()
  public List<BusStand> getAll() {
    LinkedList<BusStand> res = new LinkedList<>();
    for (BusStand busStand : busStandRepo.findAll()) {
      res.add(busStand);
    }
    return res;
  }

  @PostMapping()
  public BusStand createGuest(@Valid @RequestBody BusStand busStand) {
    return busStandRepo.save(busStand);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody BusStand busStand) {
    busStandRepo.deleteById(busStand.getId());
  }
}
