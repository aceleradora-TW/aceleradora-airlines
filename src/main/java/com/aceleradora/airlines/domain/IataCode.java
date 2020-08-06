package com.aceleradora.airlines.domain;

import java.util.Objects;

public class IataCode {

    private static final String THREE_LETTERS = "[a-zA-Z]{3}";
    private final String value;

    private IataCode(String value) {
        if (value == null || !value.matches(THREE_LETTERS)) {
            throw new IllegalArgumentException(String.format("Invalid IATA code: '%s'", value));
        }

        this.value = value.toUpperCase();
    }

    public static IataCode parse(String value) {
        return new IataCode(value);
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
