package main.java;

import static test.java.QuantityMeasurementAppTest.*;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(
                q1.equals(q2));
    }

    public static <U extends IMeasurable>
    void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        System.out.println(
                quantity.convertTo(
                        targetUnit));
    }

    public static <U extends IMeasurable>
    void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(
                q1.add(
                        q2,
                        targetUnit));
    }


    private static void demonstrateLengthSubtraction() {

        Quantity<LengthUnit> result =
                new Quantity<>(10.0, LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(6.0,
                                        LengthUnit.INCH));

        System.out.println(result);
    }

    private static void demonstrateWeightSubtraction() {

        Quantity<WeightUnit> result =
                new Quantity<>(10.0,
                        WeightUnit.KILOGRAM)
                        .subtract(
                                new Quantity<>(5000.0,
                                        WeightUnit.GRAM));

        System.out.println(result);
    }

    private static void demonstrateVolumeSubtraction() {

        Quantity<VolumeUnit> result =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE)
                        .subtract(
                                new Quantity<>(500.0,
                                        VolumeUnit.MILLILITRE));

        System.out.println(result);
    }

    private static void demonstrateLengthDivision() {

        double result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .divide(
                                new Quantity<>(2.0,
                                        LengthUnit.FEET));

        System.out.println(result);
    }

    private static void demonstrateTemperatureEquality() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        System.out.println(
                "0°C equals 32°F = "
                        + celsius.equals(fahrenheit));
    }


    private static void demonstrateTemperatureConversion() {

        Quantity<TemperatureUnit> boilingPoint =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        System.out.println(
                boilingPoint.convertTo(
                        TemperatureUnit.FAHRENHEIT));
    }

    private static void demonstrateTemperatureArithmetic() {

        try {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(
                            100.0,
                            TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(
                            50.0,
                            TemperatureUnit.CELSIUS);

            t1.add(t2);

        } catch (UnsupportedOperationException e) {

            System.out.println(
                    e.getMessage());
        }
    }

    public static void main(String[] args) {

        Quantity<LengthUnit> foot =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);

        demonstrateEquality(
                foot,
                inch);

        demonstrateConversion(
                foot,
                LengthUnit.INCH);

        demonstrateAddition(
                foot,
                inch,
                LengthUnit.FEET);

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);

        demonstrateEquality(
                kilogram,
                gram);

        demonstrateConversion(
                kilogram,
                WeightUnit.GRAM);

        demonstrateAddition(
                kilogram,
                gram,
                WeightUnit.KILOGRAM);

        demonstrateTemperatureEquality();

        demonstrateTemperatureConversion();

        demonstrateTemperatureArithmetic();
    }
}