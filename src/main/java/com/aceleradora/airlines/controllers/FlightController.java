package com.aceleradora.airlines.controllers;

import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.services.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

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

    @GetMapping("/flights/departing")
    public Collection<Flight> byDeparture(PositionCriteria criteria) {
        return service.findByDeparture(criteria);
    }

    @GetMapping("/flights/arriving")
    public Collection<Flight> byArrival(PositionCriteria criteria) {
        return service.findByArrival(criteria);
    }

    private static final class InvalidParameter {
        private final String name;
        private final Object value;

        InvalidParameter(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        String getName() {
            return name;
        }

        Object getValue() {
            return value;
        }
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Map<String, Object>> resolve(BindException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Invalid parameters received");
        body.put("invalidParameters", ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new InvalidParameter(fe.getField(), fe.getRejectedValue()))
                .collect(toList()));

        return ResponseEntity.badRequest().body(body);
    }
}
