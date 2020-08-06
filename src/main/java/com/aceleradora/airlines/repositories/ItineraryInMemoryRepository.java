package com.aceleradora.airlines.repositories;

import com.aceleradora.airlines.domain.itinerary.Itinerary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ItineraryInMemoryRepository {

    private static Collection<Itinerary> itineraries = new ArrayList<>();

    public Collection<Itinerary> findAll() {
        return itineraries;
    }

    public Optional<Itinerary> findById(String id) {
        return itineraries.stream()
                .filter(it -> it.hasId(UUID.fromString(id)))
                .findFirst();
    }

    public Itinerary save(Itinerary itinerary) {
        Itinerary itineraryWithId = itinerary.withId(UUID.randomUUID());
        itineraries.add(itineraryWithId);
        return itineraryWithId;
    }

    public void deleteAll() {
        itineraries = new ArrayList<>();
    }

    public void deleteById(String id) {
        itineraries.removeIf(it -> it.hasId(UUID.fromString(id)));
    }
}
