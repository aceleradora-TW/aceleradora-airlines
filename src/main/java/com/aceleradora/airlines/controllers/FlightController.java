package com.aceleradora.airlines.controllers;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.services.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public Collection<Flight> allFlights() {
        return flightService.findAll();
    }

    @GetMapping("/flights/carrier/{carrier}")
    public Collection<Flight> byCarrier(@PathVariable String carrier) {
        return flightService.findByCarrier(carrier);
    }

    @GetMapping("/flights/departing")
    public Collection<Flight> byDeparture(PositionCriteria criteria) {
        return flightService.findByDeparture(criteria);
    }

    @GetMapping("/flights/arriving")
    public Collection<Flight> byArrival(PositionCriteria criteria) {
        return flightService.findByArrival(criteria);
    }

    @GetMapping("/flights/long-haul")
    public Collection<Flight> longHaul(){return flightService.longHaul();}


}
