package com.aceleradora.airlines.domain.flight;

import com.aceleradora.airlines.domain.Position;

import java.util.Objects;

public final class Flight {

    private final FlightNumber number;
    private final Position departure;
    private final Position arrival;
    private final int duration;

    public Flight(FlightNumber number, Position departure, Position arrival, int duration) {
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
    }
    public int getDuration() {return duration;}

    public String getCarrier() {
        return number.getCarrier();
    }

    public String getNumber() {
        return number.getNumber();
    }

    public Position getDeparture() {
        return departure;
    }

    public Position getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(number, flight.number) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, departure, arrival);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number=" + number +
                ", departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}
