package com.aceleradora.airlines.domain.flight;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CountryCodeTest {

    @Test
    void doesNotAllowNumbers() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> CountryCode.parse("2A"));

        assertThat(thrown.getMessage(), equalTo("Invalid country code: '2A'"));
    }

    @Test
    void doesNotAllowNull() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> CountryCode.parse(null));

        assertThat(thrown.getMessage(), equalTo("Invalid country code: 'null'"));
    }

    @Test
    void doesNotAllowSpecialCharacters() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> CountryCode.parse("A~"));

        assertThat(thrown.getMessage(), equalTo("Invalid country code: 'A~'"));
    }

    @Test
    void onlyAllowsLengthOf2() {
        var tooLong = assertThrows(IllegalArgumentException.class, () -> CountryCode.parse("VAIBRASIL"));
        var tooShort = assertThrows(IllegalArgumentException.class, () -> CountryCode.parse("B"));

        assertThat(tooLong.getMessage(), equalTo("Invalid country code: 'VAIBRASIL'"));
        assertThat(tooShort.getMessage(), equalTo("Invalid country code: 'B'"));
    }

    @Test
    void isCaseInsensitive() {
        var fromLowerCase = CountryCode.parse("br");
        var fromMixedCase = CountryCode.parse("Br");

        assertThat(fromLowerCase.getValue(), equalTo("BR"));
        assertThat(fromMixedCase.getValue(), equalTo("BR"));
    }
}