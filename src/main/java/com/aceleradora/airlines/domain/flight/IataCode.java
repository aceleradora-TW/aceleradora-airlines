package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public class IataCode {

    private static final String THREE_LETTERS = "[a-zA-Z]{3}";
    private final String value;

    private IataCode(String value) {
        this.value = value;
    }

    public static IataCode parse(String value) {
        if (value == null || !value.matches(THREE_LETTERS)) {
            throw new IllegalArgumentException(String.format("Invalid IATA code: '%s'", value));
        }

        return new IataCode(value.toUpperCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IataCode iataCode = (IataCode) o;
        return Objects.equals(value, iataCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "IataCode{" +
                "value='" + value + '\'' +
                '}';
    }
}
