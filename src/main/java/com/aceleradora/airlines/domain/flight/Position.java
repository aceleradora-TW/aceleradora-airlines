package com.aceleradora.airlines.domain.flight;

import java.util.Objects;

public class Position {
    private final IataCode airport;
    private final IataCode city;
    private final CountryCode country;

    public Position(IataCode airport, IataCode city, CountryCode country) {
        this.airport = airport;
        this.city = city;
        this.country = country;
    }

    public String getAirport() {
        return airport.getValue();
    }

    public String getCity() {
        return city.getValue();
    }

    public String getCountry() {
        return country.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(airport, position.airport) &&
                Objects.equals(city, position.city) &&
                Objects.equals(country, position.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airport, city, country);
    }

    @Override
    public String toString() {
        return "Position{" +
                "airport=" + airport +
                ", city=" + city +
                ", country=" + country +
                '}';
    }
}
