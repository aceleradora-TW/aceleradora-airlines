package com.aceleradora.airlines.controllers;

import java.util.Objects;

public final class PositionCriteria {
    private String fromCity;
    private String fromAirport;
    private String fromCountry;

    public PositionCriteria(String fromCity, String fromAirport, String fromCountry) {
        this.fromCity = fromCity;
        this.fromAirport = fromAirport;
        this.fromCountry = fromCountry;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionCriteria that = (PositionCriteria) o;
        return Objects.equals(fromCity, that.fromCity) &&
                Objects.equals(fromAirport, that.fromAirport) &&
                Objects.equals(fromCountry, that.fromCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCity, fromAirport, fromCountry);
    }

    @Override
    public String toString() {
        return "PositionCriteria{" +
                "fromCity='" + fromCity + '\'' +
                ", fromAirport='" + fromAirport + '\'' +
                ", fromCountry='" + fromCountry + '\'' +
                '}';
    }
}
