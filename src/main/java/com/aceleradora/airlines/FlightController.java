package com.aceleradora.airlines;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.services.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping("/flights")
    public Collection<Flight> allFlights() {
        return service.findAll();
    }

    @GetMapping("/flights/carrier/{carrier}")
    public Collection<Flight> byCarrier(@PathVariable String carrier) {
        return service.findByCarrier(carrier);
    }
}
