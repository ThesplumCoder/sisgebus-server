package com.thesplum.sisgebusserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thesplum.sisgebusserver.models.Passenger;

/**
 * PassengerRepository
 */
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

}
