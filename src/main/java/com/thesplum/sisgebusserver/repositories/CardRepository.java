package com.thesplum.sisgebusserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thesplum.sisgebusserver.models.Card;

/**
 * CardRepository
 */
public interface CardRepository extends CrudRepository<Card, Integer> {

}
