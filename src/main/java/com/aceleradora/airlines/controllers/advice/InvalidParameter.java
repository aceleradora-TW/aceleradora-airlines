package com.aceleradora.airlines.controllers.advice;

final class InvalidParameter {
    private final String name;
    private final Object value;

    InvalidParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    String getName() {
        return name;
    }

    Object getValue() {
        return value;
    }
}
