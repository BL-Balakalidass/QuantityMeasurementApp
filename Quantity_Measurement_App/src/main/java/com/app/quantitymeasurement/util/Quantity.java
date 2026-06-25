package com.app.quantitymeasurement.util;

import java.util.Objects;

public class Quantity<T extends Enum<T> & IMeasurable> {

    private final double value;
    private final T unit;

    public Quantity(double value, T unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public T getUnit() {
        return unit;
    }

    public double toBaseUnit() {
        return unit.toBaseUnit(value);
    }

    public Quantity<T> convertTo(T targetUnit) {

        double baseValue = unit.toBaseUnit(value);

        double convertedValue =
                targetUnit.fromBaseUnit(baseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    public boolean compare(Quantity<T> other) {

        return Math.abs(
                this.toBaseUnit()
                        - other.toBaseUnit()
        ) < 0.0001;
    }

    public Quantity<T> add(Quantity<T> other) {

        double result =
                this.toBaseUnit()
                        + other.toBaseUnit();

        return new Quantity<>(
                unit.fromBaseUnit(result),
                unit
        );
    }

    public Quantity<T> subtract(Quantity<T> other) {

        double result =
                this.toBaseUnit()
                        - other.toBaseUnit();

        return new Quantity<>(
                unit.fromBaseUnit(result),
                unit
        );
    }

    public double divide(Quantity<T> other) {

        if (other.toBaseUnit() == 0) {
            throw new ArithmeticException(
                    "Divide by zero"
            );
        }

        return this.toBaseUnit()
                / other.toBaseUnit();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?> quantity)) {
            return false;
        }

        return Math.abs(
                this.toBaseUnit()
                        - quantity.toBaseUnit()
        ) < 0.0001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Math.round(toBaseUnit() * 1000)
        );
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}