package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public class CountryCode {

    private static final String TWO_LETTERS = "[A-Za-z]{2}";
    private final String value;

    private CountryCode(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    public static CountryCode parse(String value) {
        if (value == null || !value.matches(TWO_LETTERS)) {
            throw new IllegalArgumentException(String.format("Invalid country code: '%s'", value));
        }
        return new CountryCode(value.toUpperCase());
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
