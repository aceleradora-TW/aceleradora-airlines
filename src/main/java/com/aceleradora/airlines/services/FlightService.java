package com.aceleradora.airlines.services;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.repositories.FlightInMemoryRepository;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private final FlightInMemoryRepository repository;

    public FlightService(FlightInMemoryRepository repository) {
        this.repository = repository;
    }

    public Collection<Flight> findByCarrier(String carrier) {
        return repository.findAll().stream()
                .filter(flight -> flight.getCarrier().equalsIgnoreCase(carrier))
                .collect(toList());
    }
}
