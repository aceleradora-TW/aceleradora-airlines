package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public class CountryCode {

    private final String value;

    private CountryCode(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    public static CountryCode parse(String value) {
        return new CountryCode(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCode that = (CountryCode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CountryCode{" +
                "value='" + value + '\'' +
                '}';
    }
}
