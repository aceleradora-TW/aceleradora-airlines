package com.aceleradora.airlines.controllers.converters;

import com.aceleradora.airlines.domain.CountryCode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryCodeConverter implements Converter<String, CountryCode> {

    @Override
    public CountryCode convert(String source) {
        return CountryCode.parse(source);
    }
}
