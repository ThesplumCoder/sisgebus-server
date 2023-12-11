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

import com.thesplum.sisgebusserver.models.Route;
import com.thesplum.sisgebusserver.repositories.RouteRepository;

/**
 * Controlador de peticiones para el modelo de Ruta.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/route")
public class RouteController {

  @Autowired
  private RouteRepository routeRepo;

  @GetMapping()
  public List<Route> getAll() {
    LinkedList<Route> res = new LinkedList<>();
    for (Route route : routeRepo.findAll()) {
      res.add(route);
    }
    return res;
  }

  @PostMapping()
  public Route addRoute(@Valid @RequestBody Route route) {
    return routeRepo.save(route);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody Route route) {
    routeRepo.deleteById(route.getId());
  }
}
