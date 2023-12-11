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

import com.thesplum.sisgebusserver.models.PaymentMethod;
import com.thesplum.sisgebusserver.repositories.PaymentMethodRepository;

/**
 * Controlador de peticiones para el modelo de Métodos de Pago.
 *
 * @author Anderson Acuña (ThesplumCoder).
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payment-method")
public class PaymentMethodController {

  @Autowired
  private PaymentMethodRepository paymentMethodRepo;

  @GetMapping()
  public List<PaymentMethod> getAll() {
    LinkedList<PaymentMethod> res = new LinkedList<>();
    for (PaymentMethod paymentMethod : paymentMethodRepo.findAll()) {
      res.add(paymentMethod);
    }
    return res;
  }

  @PostMapping()
  public PaymentMethod addPaymentMethod(@Valid @RequestBody PaymentMethod paymentMethod) {
    return paymentMethodRepo.save(paymentMethod);
  }

  @DeleteMapping()
  public void deleteById(@RequestBody PaymentMethod paymentMethod) {
    paymentMethodRepo.deleteById(paymentMethod.getId());
  }
}
