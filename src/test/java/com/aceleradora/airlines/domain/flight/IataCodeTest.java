package com.aceleradora.airlines.domain.flight;

import com.aceleradora.airlines.domain.IataCode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class IataCodeTest {

    @Test
    void doesNotAllowNumbers() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> IataCode.parse("A2A"));

        assertThat(thrown.getMessage(), equalTo("Invalid IATA code: 'A2A'"));
    }

    @Test
    void doesNotAllowNull() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> IataCode.parse(null));

        assertThat(thrown.getMessage(), equalTo("Invalid IATA code: 'null'"));
    }

    @Test
    void doesNotAllowSpecialCharacters() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> IataCode.parse("AA~"));

        assertThat(thrown.getMessage(), equalTo("Invalid IATA code: 'AA~'"));
    }

    @Test
    void onlyAllowsLengthOf3() {
        var tooLong = assertThrows(IllegalArgumentException.class, () -> IataCode.parse("ALVORADA"));
        var tooShort = assertThrows(IllegalArgumentException.class, () -> IataCode.parse("A"));

        assertThat(tooLong.getMessage(), equalTo("Invalid IATA code: 'ALVORADA'"));
        assertThat(tooShort.getMessage(), equalTo("Invalid IATA code: 'A'"));
    }

    @Test
    void isCaseInsensitive() {
        var fromLowerCase = IataCode.parse("bsb");
        var fromMixedCase = IataCode.parse("BsB");

        assertThat(fromLowerCase.getValue(), equalTo("BSB"));
        assertThat(fromMixedCase.getValue(), equalTo("BSB"));
    }
}