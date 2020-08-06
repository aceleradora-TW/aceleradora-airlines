package com.aceleradora.airlines.domain;

import java.util.Objects;

public class CountryCode {

    private static final String TWO_LETTERS = "[A-Za-z]{2}";
    private final String value;

    private CountryCode(String value) {
        if (value == null || !value.matches(TWO_LETTERS)) {
            throw new IllegalArgumentException(String.format("Invalid country code: '%s'", value));
        }
        this.value = value.toUpperCase();
    }

    public String getValue() {
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
