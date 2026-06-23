package main.java;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 0.000001;

    private final double value;
    private final U unit;

    public Quantity(
            double value,
            U unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Invalid value");
        }

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(
            U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    public Quantity<U> add(
            Quantity<U> other) {

        return add(
                other,
                this.unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        double sumBase =
                thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(
                        sumBase);

        return new Quantity<>(
                result,
                targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null ||
                getClass() != obj.getClass()) {
            return false;
        }

        Quantity<?> other =
                (Quantity<?>) obj;

        if (this.unit.getClass() !=
                other.unit.getClass()) {
            return false;
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(
                thisBase - otherBase)
                < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Double.hashCode(baseValue);
    }

    @Override
    public String toString() {

        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}