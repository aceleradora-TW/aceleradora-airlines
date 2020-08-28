package com.aceleradora.airlines.domain;

public class Aircraft {
    private final String manufacturer;
    private final String model;

    public Aircraft(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel(){
        return model;
    }
}

