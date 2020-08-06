package com.aceleradora.airlines.services;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.domain.flight.FlightNumber;
import com.aceleradora.airlines.repositories.FlightInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class FlightServiceTest {

    private FlightService service;

    @BeforeEach
    void setUp() {
        service = new FlightService(new FlightInMemoryRepository());
    }

    @Test
    void filtersFlightsByCarriers() {
        Collection<Flight> flightsByGol = service.findByCarrier("G3");

        assertThat(flightsByGol, equalTo(List.of(
                new Flight(new FlightNumber("G3", "1011")),
                new Flight(new FlightNumber("G3", "1327")))));
    }
}