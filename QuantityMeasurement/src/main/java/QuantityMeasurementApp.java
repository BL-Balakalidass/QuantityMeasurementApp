package main.java;

public class QuantityMeasurementApp {

    public static double convert(
            double value,
            LengthUnit sourceUnit,
            LengthUnit targetUnit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Value must be finite");
        }

        if (sourceUnit == null ||
                targetUnit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        double baseValue =
                sourceUnit.convertToBaseUnit(
                        value);

        return targetUnit.convertFromBaseUnit(
                baseValue);
    }

    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inch =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCH);

        System.out.println(
                feet.convertTo(
                        LengthUnit.INCH));

        System.out.println(
                feet.add(
                        inch,
                        LengthUnit.FEET));

        System.out.println(
                feet.add(
                        inch,
                        LengthUnit.YARD));

        System.out.println(
                new QuantityLength(
                        36.0,
                        LengthUnit.INCH)
                        .equals(
                                new QuantityLength(
                                        1.0,
                                        LengthUnit.YARD)));
    }
}