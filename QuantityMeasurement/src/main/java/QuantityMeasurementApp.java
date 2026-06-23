package main.java;

public class QuantityMeasurementApp {

    private static final double EPSILON = 0.000001;

    public enum LengthUnit {

        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.393701 / 12.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }

            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        private double convertToFeet() {
            return value * unit.getConversionFactor();
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double convertedValue =
                    QuantityMeasurementApp.convert(
                            value,
                            unit,
                            targetUnit);

            return new QuantityLength(
                    convertedValue,
                    targetUnit);
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            QuantityLength other =
                    (QuantityLength) obj;

            return Math.abs(
                    this.convertToFeet()
                            - other.convertToFeet())
                    < EPSILON;
        }

        @Override
        public String toString() {

            return "QuantityLength{" +
                    "value=" + value +
                    ", unit=" + unit +
                    '}';
        }
    }

    public static double convert(
            double value,
            LengthUnit sourceUnit,
            LengthUnit targetUnit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        double valueInFeet =
                value * sourceUnit.getConversionFactor();

        return valueInFeet /
                targetUnit.getConversionFactor();
    }

    public static void demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        double result =
                convert(value, fromUnit, toUnit);

        System.out.println(
                value + " " +
                        fromUnit +
                        " = " +
                        result +
                        " " +
                        toUnit);
    }

    public static void demonstrateLengthConversion(
            QuantityLength quantity,
            LengthUnit targetUnit) {

        QuantityLength converted =
                quantity.convertTo(targetUnit);

        System.out.println(converted);
    }

    public static void demonstrateLengthEquality(
            QuantityLength length1,
            QuantityLength length2) {

        System.out.println(
                "Equal = " +
                        length1.equals(length2));
    }

    public static void demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        QuantityLength length1 =
                new QuantityLength(value1, unit1);

        QuantityLength length2 =
                new QuantityLength(value2, unit2);

        demonstrateLengthEquality(
                length1,
                length2);
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCH);

        demonstrateLengthConversion(
                1.0,
                LengthUnit.YARD,
                LengthUnit.INCH);

        demonstrateLengthConversion(
                2.54,
                LengthUnit.CENTIMETER,
                LengthUnit.INCH);

        demonstrateLengthComparison(
                1.0,
                LengthUnit.YARD,
                36.0,
                LengthUnit.INCH);
    }
}