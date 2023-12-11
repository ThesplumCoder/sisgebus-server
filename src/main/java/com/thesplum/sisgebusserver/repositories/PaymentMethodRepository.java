package com.thesplum.sisgebusserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thesplum.sisgebusserver.models.PaymentMethod;

/**
 * PaymentMethodRepository
 */
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Integer> {

}
