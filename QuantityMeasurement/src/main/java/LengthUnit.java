package main.java;

public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        return value * conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) {

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException("Invalid value");
        }

        return baseValue / conversionFactor;
    }
}