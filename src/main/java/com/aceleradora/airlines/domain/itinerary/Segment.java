package com.aceleradora.airlines.domain.itinerary;

import com.aceleradora.airlines.domain.Position;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class Segment {

    private Position origin;
    private Position destination;

    @JsonCreator
    public Segment(Position origin, Position destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Position getOrigin() {
        return origin;
    }

    public Position getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Objects.equals(origin, segment.origin) &&
                Objects.equals(destination, segment.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination);
    }

    @Override
    public String toString() {
        return "Segment{" +
                "origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
