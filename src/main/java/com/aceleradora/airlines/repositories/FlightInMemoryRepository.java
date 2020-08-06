package com.aceleradora.airlines.repositories;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.domain.flight.FlightNumber;

import java.util.Collection;
import java.util.List;

public class FlightInMemoryRepository {

    public Collection<Flight> findAll() {
        return List.of(
                new Flight(new FlightNumber("AZU", "1060")),
                new Flight(new FlightNumber("AZU", "2030")),
                new Flight(new FlightNumber("LAN", "1766")),
                new Flight(new FlightNumber("LAN", "1550")),
                new Flight(new FlightNumber("G3", "1011")),
                new Flight(new FlightNumber("G3", "1327")));
    }
}
