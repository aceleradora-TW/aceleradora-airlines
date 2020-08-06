package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public class IataCode {

    private final String value;

    private IataCode(String value) {
        this.value = value;
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
