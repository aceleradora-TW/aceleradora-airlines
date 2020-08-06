package com.aceleradora.airlines.domain.flight;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightNumberTest {

    @Test
    void failsWhenContentLengthIsTooShort() {
        var thrownEmpty = assertThrows(IllegalArgumentException.class, () -> FlightNumber.parse(""));
        var thrownSmallNumber = assertThrows(IllegalArgumentException.class, () -> FlightNumber.parse("20"));

        assertThat(thrownEmpty.getMessage(), equalTo("Invalid flight number: ''"));
        assertThat(thrownSmallNumber.getMessage(), equalTo("Invalid flight number: '20'"));
    }

    @Test
    void parsesCarrierNameIncludingNumbers() {
        var number = FlightNumber.parse("G31327");

        assertThat(number.getCarrier(), equalTo("G3"));
        assertThat(number.getNumber(), equalTo("1327"));
    }
}