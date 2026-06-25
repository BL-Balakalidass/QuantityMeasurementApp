package com.app.quantitymeasurement.util;

public enum VolumeUnit implements IMeasurable {

    LITER(1.0),
    MILLILITER(0.001),
    GALLON(3.78);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double fromBaseUnit(double value) {
        return value / conversionFactor;
    }
}