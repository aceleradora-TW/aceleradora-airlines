package com.aceleradora.airlines.repositories;

import com.aceleradora.airlines.domain.flight.CountryCode;
import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.domain.flight.FlightNumber;
import com.aceleradora.airlines.domain.flight.IataCode;
import com.aceleradora.airlines.domain.flight.Position;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class FlightInMemoryRepository {
    public static final CountryCode BRASIL = CountryCode.parse("BR");
    public static final CountryCode ARGENTINA = CountryCode.parse("AR");
    public static final CountryCode CHILE = CountryCode.parse("CL");
    public static final IataCode PORTO_ALEGRE = IataCode.parse("POA");
    public static final IataCode RIO_DE_JANEIRO = IataCode.parse("RIO");
    public static final IataCode SAO_PAULO = IataCode.parse("SAO");
    public static final IataCode CONGONHAS = IataCode.parse("CGH");
    public static final IataCode SALGADO_FILHO = IataCode.parse("POA");
    public static final IataCode BUENOS_AIRES = IataCode.parse("BUE");
    public static final IataCode AEROPARQUE_JORGE_NEWBERY = IataCode.parse("AEP");
    public static final IataCode SANTIAGO = IataCode.parse("SCL");
    public static final IataCode COMODORO_ARTURO_MERINO_BENITEZ = IataCode.parse("SCL");
    public static final IataCode GALEAO = IataCode.parse("GIG");
    public static final IataCode GUARULHOS = IataCode.parse("GRU");

    public Collection<Flight> findAll() {
        return List.of(
                new Flight(
                        new FlightNumber("AZU", "1060"),
                        new Position(SALGADO_FILHO, PORTO_ALEGRE, BRASIL),
                        new Position(CONGONHAS, SAO_PAULO, BRASIL)),
                new Flight(
                        new FlightNumber("AZU", "2030"),
                        new Position(SALGADO_FILHO, PORTO_ALEGRE, BRASIL),
                        new Position(AEROPARQUE_JORGE_NEWBERY, BUENOS_AIRES, ARGENTINA)),
                new Flight(
                        new FlightNumber("LAN", "744"),
                        new Position(SALGADO_FILHO, PORTO_ALEGRE, BRASIL),
                        new Position(COMODORO_ARTURO_MERINO_BENITEZ, SANTIAGO, CHILE)),
                new Flight(
                        new FlightNumber("LAN", "1550"),
                        new Position(GALEAO, RIO_DE_JANEIRO, BRASIL),
                        new Position(SALGADO_FILHO, PORTO_ALEGRE, BRASIL)),
                new Flight(
                        new FlightNumber("G3", "1011"),
                        new Position(COMODORO_ARTURO_MERINO_BENITEZ, SANTIAGO, CHILE),
                        new Position(SALGADO_FILHO, PORTO_ALEGRE, BRASIL)),
                new Flight(
                        new FlightNumber("G3", "1327"),
                        new Position(GUARULHOS, SAO_PAULO, BRASIL),
                        new Position(GALEAO, RIO_DE_JANEIRO, BRASIL)));
    }
}
