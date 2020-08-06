package com.aceleradora.airlines.controllers;

import com.aceleradora.airlines.domain.flight.CountryCode;
import com.aceleradora.airlines.domain.flight.IataCode;

import java.util.Objects;

public final class PositionCriteria {
    private IataCode city;
    private IataCode airport;
    private CountryCode country;

    public PositionCriteria(IataCode city, IataCode airport, CountryCode country) {
        this.city = city;
        this.airport = airport;
        this.country = country;
    }

    public IataCode getCity() {
        return city;
    }

    public IataCode getAirport() {
        return airport;
    }

    public CountryCode getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionCriteria that = (PositionCriteria) o;
        return Objects.equals(city, that.city) &&
                Objects.equals(airport, that.airport) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, airport, country);
    }

    @Override
    public String toString() {
        return "PositionCriteria{" +
                "fromCity='" + city + '\'' +
                ", fromAirport='" + airport + '\'' +
                ", fromCountry='" + country + '\'' +
                '}';
    }
}
