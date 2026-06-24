package main.java;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(
            celsius -> celsius,
            celsius -> celsius,
            "Celsius"
    ),

    FAHRENHEIT(
            fahrenheit -> (fahrenheit - 32) * 5.0 / 9.0,
            celsius -> (celsius * 9.0 / 5.0) + 32,
            "Fahrenheit"
    ),

    KELVIN(
            kelvin -> kelvin - 273.15,
            celsius -> celsius + 273.15,
            "Kelvin"
    );

    private final Function<Double, Double> toBaseConverter;
    private final Function<Double, Double> fromBaseConverter;
    private final String unitName;

    TemperatureUnit(
            Function<Double, Double> toBaseConverter,
            Function<Double, Double> fromBaseConverter,
            String unitName) {

        this.toBaseConverter = toBaseConverter;
        this.fromBaseConverter = fromBaseConverter;
        this.unitName = unitName;
    }

    @Override
    public double getConversionFactor() {
        return 0;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return toBaseConverter.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return fromBaseConverter.apply(baseValue);
    }

    @Override
    public String getUnitName() {
        return unitName;
    }

    @Override
    public SupportsArithmetic getArithmeticSupport() {
        return () -> false;
    }

    @Override
    public boolean supportsArithmetic() {
        return IMeasurable.super.supportsArithmetic();
    }

    @Override
    public void validateOperationSupport(String operation) {

        throw new UnsupportedOperationException(
                "Temperature measurements do not support "
                        + operation
                        + " operation"
        );
    }
}