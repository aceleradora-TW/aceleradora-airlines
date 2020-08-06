package com.aceleradora.airlines.services;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.repositories.FlightInMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Service
public class FlightService {

    private final FlightInMemoryRepository repository;

    public FlightService(FlightInMemoryRepository repository) {
        this.repository = repository;
    }

    public Collection<Flight> findAll() {
        return repository.findAll();
    }

    public Collection<Flight> findByCarrier(String carrier) {
        return repository.findAll().stream()
                .filter(flight -> flight.getCarrier().equalsIgnoreCase(carrier))
                .collect(toList());
    }
}
