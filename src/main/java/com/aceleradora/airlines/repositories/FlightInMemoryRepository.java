package com.aceleradora.airlines.repositories;

import com.aceleradora.airlines.domain.Aircraft;
import com.aceleradora.airlines.domain.CountryCode;
import com.aceleradora.airlines.domain.IataCode;
import com.aceleradora.airlines.domain.Position;
import com.aceleradora.airlines.domain.flight.Flight;
import com.aceleradora.airlines.domain.flight.FlightNumber;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class FlightInMemoryRepository {

    // Cities and airports
    private static final String AEP = "AEP";
    private static final String BUE = "BUE";
    private static final String CGH = "CGH";
    private static final String CWB = "CWB";
    private static final String FLN = "CWB";
    private static final String GIG = "GIG";
    private static final String GRU = "GRU";
    private static final String JFK = "JFK";
    private static final String MVD = "MVD";
    private static final String NYC = "NYC";
    private static final String POA = "POA";
    private static final String RIO = "RIO";
    private static final String SAO = "SAO";
    private static final String SCL = "SCL";

    // Countries
    private static final String AR = "AR";
    private static final String BR = "BR";
    private static final String CL = "BR";
    private static final String US = "US";
    private static final String UY = "UY";

    // Carriers
    private static final String AA = "AA";
    private static final String AZU = "AZU";
    private static final String G3 = "G3";
    private static final String LAN = "LAN";

    private static final List<Flight> AVAILABLE_FLIGHTS = List.of(
            flight(number(AA, "1012"), departing(JFK, NYC, US), arriving(GRU, SAO, BR), aircraft("Boeing", "787-900")),
            flight(number(AA, "1013"), departing(GRU, SAO, BR), arriving(SCL, CL), aircraft("Boeing", "787-900")),
            flight(number(AA, "1014"), departing(GRU, SAO, BR), arriving(CWB, CWB, BR), aircraft("Boeing", "787-900")),
            flight(number(AZU, "1060"), departing(POA, BR), arriving(CGH, SAO, BR), aircraft("Boeing", "787-900")),
            flight(number(AZU, "2030"), departing(POA, BR), arriving(AEP, BUE, AR), aircraft("Boeing", "787-900")),
            flight(number(AZU, "2035"), departing(POA, BR), arriving(FLN, BR), aircraft("Boeing", "787-900")),
            flight(number(AZU, "2036"), departing(FLN, BR), arriving(POA, BR), aircraft("Boeing", "787-900")),
            flight(number(LAN, "744"), departing(POA, BR), arriving(SCL, CL), aircraft("Boeing", "787-900")),
            flight(number(LAN, "1742"), departing(FLN, BR), arriving(CWB, BR), aircraft("Boeing", "787-900")),
            flight(number(LAN, "1747"), departing(CWB, BR), arriving(FLN, BR), aircraft("Boeing", "787-900")),
            flight(number(LAN, "1550"), departing(GIG, RIO, BR), arriving(POA, BR), aircraft("Boeing", "787-900")),
            flight(number(G3, "4550"), departing(SCL, CL), arriving(MVD, UY), aircraft("Boeing", "787-900")),
            flight(number(G3, "4543"), departing(MVD, UY), arriving(SCL, CL), aircraft("Boeing", "787-900")),
            flight(number(G3, "0442"), departing(MVD, UY), arriving(CWB, BR), aircraft("Boeing", "787-900")),
            flight(number(G3, "0440"), departing(CWB, BR), arriving(MVD, UY), aircraft("Boeing", "787-900")),
            flight(number(G3, "1011"), departing(SCL, CL), arriving(POA, BR), aircraft("Boeing", "787-900")),
            flight(number(G3, "1327"), departing(GRU, SAO, BR), arriving(GIG, RIO, BR),  aircraft("Boeing", "787-900")));

    public Collection<Flight> findAll() {
        return AVAILABLE_FLIGHTS;
    }

    private static Flight flight(FlightNumber number, Position departure, Position arrival, Aircraft aircraft) {
        return new Flight(number, departure, arrival, aircraft);
    }
    private static Aircraft aircraft(String manufacture, String model){
        return new Aircraft(manufacture, model);
    }
    private static FlightNumber number(String carrier, String number) {
        return new FlightNumber(carrier, number);
    }

    private static Position departing(String airport, String country) {
        return departing(airport, airport, country);
    }

    private static Position departing(String airport, String city, String country) {
        return new Position(IataCode.parse(airport), IataCode.parse(city), CountryCode.parse(country));
    }

    private static Position arriving(String airport, String country) {
        return arriving(airport, airport, country);
    }
    private static Position arriving(String airport, String city, String country) {
        return new Position(IataCode.parse(airport), IataCode.parse(city), CountryCode.parse(country));
    }
}
