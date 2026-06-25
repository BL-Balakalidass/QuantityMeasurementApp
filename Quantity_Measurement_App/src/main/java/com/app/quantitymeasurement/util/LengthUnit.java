package com.app.quantitymeasurement.util;

public enum LengthUnit implements IMeasurable {

    INCH(1.0),
    FEET(12.0),
    YARD(36.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
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