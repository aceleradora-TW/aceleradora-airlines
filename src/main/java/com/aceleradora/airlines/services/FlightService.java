package com.aceleradora.airlines.services;

import com.aceleradora.airlines.controllers.PositionCriteria;
import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.domain.flight.Position;
import com.aceleradora.airlines.repositories.FlightInMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

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
        return findByPredicate(f -> f.getCarrier().equalsIgnoreCase(carrier));
    }

    public Collection<Flight> findByDeparture(PositionCriteria criteria) {
        return findByPosition(Flight::getDeparture, criteria);
    }

    public Collection<Flight> findByArrival(PositionCriteria criteria) {
        return findByPosition(Flight::getArrival, criteria);
    }

    private Collection<Flight> findByPosition(Function<Flight, Position> getter, PositionCriteria criteria) {
        return findByPredicate(cityMatches(getter, criteria)
                .or(airportMatches(getter, criteria))
                .or(countryMatches(getter, criteria)));
    }

    private Collection<Flight> findByPredicate(Predicate<Flight> predicate) {
        return repository.findAll().stream()
                .filter(predicate)
                .collect(toList());
    }

    private Predicate<Flight> cityMatches(Function<Flight, Position> getter, PositionCriteria criteria) {
        return f -> getter.apply(f).getCity().equalsIgnoreCase(criteria.getFromCity());
    }

    private Predicate<Flight> airportMatches(Function<Flight, Position> getter, PositionCriteria criteria) {
        return f -> getter.apply(f).getAirport().equalsIgnoreCase(criteria.getFromAirport());
    }

    private Predicate<Flight> countryMatches(Function<Flight, Position> getter, PositionCriteria criteria) {
        return f -> getter.apply(f).getCountry().equalsIgnoreCase(criteria.getFromCountry());
    }
}
