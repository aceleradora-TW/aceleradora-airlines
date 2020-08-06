package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public final class Flight {

    private final FlightNumber number;

    public Flight(FlightNumber number) {
        this.number = number;
    }

    public String getCarrier() {
        return number.getCarrier();
    }

    public String getNumber() {
        return number.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(number, flight.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number=" + number +
                '}';
    }
}
