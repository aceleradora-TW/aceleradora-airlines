package com.aceleradora.airlines.controllers;

import com.aceleradora.airlines.domain.itinerary.Itinerary;
import com.aceleradora.airlines.repositories.ItineraryInMemoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ItineraryController {

    private final ItineraryInMemoryRepository repository;

    public ItineraryController(ItineraryInMemoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/itinerary/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        var itinerary = repository.findById(id);

        if (itinerary.isPresent()) {
            return ResponseEntity.ok(itinerary);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/itinerary/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/itinerary")
    public ResponseEntity<Itinerary> create(@RequestBody Itinerary itinerary) {
        System.out.println(itinerary);
        Itinerary savedItinerary = repository.save(itinerary);
        System.out.println(savedItinerary);

        return ResponseEntity.status(CREATED).body(savedItinerary);
    }

    @GetMapping("/itineraries")
    public Collection<Itinerary> getAll() {
        return repository.findAll();
    }

    @DeleteMapping("/itineraries")
    public ResponseEntity<Void> clearAll() {
        repository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
