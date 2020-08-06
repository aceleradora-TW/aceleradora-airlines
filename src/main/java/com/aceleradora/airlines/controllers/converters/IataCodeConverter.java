package com.aceleradora.airlines.controllers.converters;

import com.aceleradora.airlines.domain.flight.IataCode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IataCodeConverter implements Converter<String, IataCode> {

    @Override
    public IataCode convert(String source) {
        return IataCode.parse(source);
    }
}
