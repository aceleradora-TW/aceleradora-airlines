package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public final class FlightNumber {
    private final String carrier;
    private final String number;

    public FlightNumber(String carrier, String number) {
        this.carrier = carrier;
        this.number = number;
    }

    String getCarrier() {
        return carrier;
    }

    String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightNumber that = (FlightNumber) o;
        return Objects.equals(carrier, that.carrier) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrier, number);
    }

    @Override
    public String toString() {
        return "FlightNumber{" +
                "carrier='" + carrier + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
