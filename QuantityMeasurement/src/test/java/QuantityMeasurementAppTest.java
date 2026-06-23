package test.java;

import main.java.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.000001;

    @Test
    void testConversion_FeetToInches() {

        assertEquals(
                12.0,
                QuantityMeasurementApp.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {

        assertEquals(
                2.0,
                QuantityMeasurementApp.convert(
                        24.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {

        assertEquals(
                36.0,
                QuantityMeasurementApp.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_InchesToYards() {

        assertEquals(
                2.0,
                QuantityMeasurementApp.convert(
                        72.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.YARD),
                EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {

        assertEquals(
                1.0,
                QuantityMeasurementApp.convert(
                        2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER,
                        QuantityMeasurementApp.LengthUnit.INCH),
                0.001);
    }

    @Test
    void testConversion_FeetToYards() {

        assertEquals(
                2.0,
                QuantityMeasurementApp.convert(
                        6.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.YARD),
                EPSILON);
    }

    @Test
    void testConversion_RoundTrip_PreservesValue() {

        double original = 10.0;

        double inches =
                QuantityMeasurementApp.convert(
                        original,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH);

        double result =
                QuantityMeasurementApp.convert(
                        inches,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(
                original,
                result,
                EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {

        assertEquals(
                0.0,
                QuantityMeasurementApp.convert(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {

        assertEquals(
                -12.0,
                QuantityMeasurementApp.convert(
                        -1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.convert(
                        1.0,
                        null,
                        QuantityMeasurementApp.LengthUnit.FEET));
    }

    @Test
    void testConversion_NaN_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.convert(
                        Double.NaN,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH));
    }

    @Test
    void testConversion_Infinite_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.convert(
                        Double.POSITIVE_INFINITY,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH));
    }

    @Test
    void testConversion_PrecisionTolerance() {

        double result =
                QuantityMeasurementApp.convert(
                        2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(
                1.0,
                result,
                0.001);
    }

    @Test
    void testSameUnitConversion() {

        assertEquals(
                5.0,
                QuantityMeasurementApp.convert(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testInstanceConvertToMethod() {

        QuantityMeasurementApp.QuantityLength length =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD);

        QuantityMeasurementApp.QuantityLength converted =
                length.convertTo(
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(
                3.0,
                converted.getValue(),
                EPSILON);
    }
}