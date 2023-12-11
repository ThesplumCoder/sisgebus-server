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

import com.thesplum.sisgebusserver.models.Card;
import com.thesplum.sisgebusserver.repositories.CardRepository;

/**
 * Controlador de peticiones para el modelo de tarjetas.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/card")
public class CardController {

  @Autowired
  private CardRepository cardRepo;

  @GetMapping()
  public List<Card> getAll() {
    LinkedList<Card> res = new LinkedList<>();
    for (Card card : cardRepo.findAll()) {
      res.add(card);
    }
    return res;
  }

  @PostMapping()
  public Card addCard(@Valid @RequestBody Card card) {
    return cardRepo.save(card);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody Card card) {
    cardRepo.deleteById(card.getId());
  }
}
