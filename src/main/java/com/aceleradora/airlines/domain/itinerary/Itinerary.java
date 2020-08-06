package com.aceleradora.airlines.domain.itinerary;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Itinerary {

    private final UUID id;
    private final List<Segment> segments;

    @JsonCreator
    public Itinerary(List<Segment> segments) {
        this(segments, null);
    }

    private Itinerary(List<Segment> segments, UUID id) {
        this.id = id;
        this.segments = segments;
    }

    public boolean hasId(UUID otherId) {
        return id != null && id.equals(otherId);
    }

    public UUID getId() {
        return id;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public Itinerary withId(UUID id) {
        return new Itinerary(segments, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerary itinerary = (Itinerary) o;
        return Objects.equals(id, itinerary.id) &&
                Objects.equals(segments, itinerary.segments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, segments);
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", segments=" + segments +
                '}';
    }
}
