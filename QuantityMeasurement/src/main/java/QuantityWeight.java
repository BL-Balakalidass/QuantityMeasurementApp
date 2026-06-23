package main.java;

public class QuantityWeight {

    private static final double EPSILON = 0.000001;

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(
            double value,
            WeightUnit unit) {

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

    public WeightUnit getUnit() {
        return unit;
    }

    public QuantityWeight convertTo(
            WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        return new QuantityWeight(
                convertedValue,
                targetUnit);
    }

    public QuantityWeight add(
            QuantityWeight other) {

        return add(
                other,
                this.unit);
    }

    public QuantityWeight add(
            QuantityWeight other,
            WeightUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Weight cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double firstBase =
                this.unit.convertToBaseUnit(
                        this.value);

        double secondBase =
                other.unit.convertToBaseUnit(
                        other.value);

        double sumBase =
                firstBase + secondBase;

        double result =
                targetUnit.convertFromBaseUnit(
                        sumBase);

        return new QuantityWeight(
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

        QuantityWeight other =
                (QuantityWeight) obj;

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

        return "QuantityWeight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}