package com.thesplum.sisgebusserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thesplum.sisgebusserver.models.Bus;

/**
 * BusRepository
 */
public interface BusRepository extends CrudRepository<Bus, Integer> {

}
