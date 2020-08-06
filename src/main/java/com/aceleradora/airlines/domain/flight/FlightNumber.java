package com.aceleradora.airlines.domain.flight;

public final class FlightNumber {
    private final String carrier;
    private final String number;

    private FlightNumber(String carrier, String number) {
        this.carrier = carrier;
        this.number = number;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getNumber() {
        return number;
    }

    public static FlightNumber parse(String number) {
        if (number == null || number.length() < 6) {
            throw new IllegalArgumentException(String.format("Invalid flight number: '%s'", number));
        }

        return new FlightNumber(
                number.substring(0, 2),
                number.substring(2));
    }
}
