package main.java;

public class QuantityMeasurementApp {

    public enum LengthUnit {

        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.0328084167);

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

            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        private double convertToFeet() {
            return value * unit.getConversionFactor();
        }

        private static final double EPSILON = 0.00001;

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(
                    this.convertToFeet()
                            - other.convertToFeet()
            ) < EPSILON;
        }
    }

    public static boolean checkLengthEquality(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        QuantityLength quantity1 =
                new QuantityLength(value1, unit1);

        QuantityLength quantity2 =
                new QuantityLength(value2, unit2);

        return quantity1.equals(quantity2);
    }

    public static void main(String[] args) {

        System.out.println(
                checkLengthEquality(
                        1.0,
                        LengthUnit.YARD,
                        3.0,
                        LengthUnit.FEET));

        System.out.println(
                checkLengthEquality(
                        1.0,
                        LengthUnit.YARD,
                        36.0,
                        LengthUnit.INCH));

        System.out.println(
                checkLengthEquality(
                        1.0,
                        LengthUnit.CENTIMETER,
                        0.393701,
                        LengthUnit.INCH));
    }
}