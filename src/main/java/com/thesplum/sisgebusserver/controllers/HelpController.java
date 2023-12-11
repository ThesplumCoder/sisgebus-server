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

import com.thesplum.sisgebusserver.models.Help;
import com.thesplum.sisgebusserver.repositories.HelpRepository;

/**
 * Controlador de peticiones para el modelo de Ayuda.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/help")
public class HelpController {

  @Autowired
  private HelpRepository helpRepo;

  @GetMapping()
  public List<Help> getAll() {
    LinkedList<Help> res = new LinkedList<>();
    for (Help help : helpRepo.findAll()) {
      res.add(help);
    }
    return res;
  }

  @PostMapping()
  public Help addHelp(@Valid @RequestBody Help help) {
    return helpRepo.save(help);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody Help help) {
    helpRepo.deleteById(help.getId());
  }
}
