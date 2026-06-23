package test.java;

import main.java.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {

        QuantityMeasurementApp.QuantityLength quantity1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength quantity2 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(quantity1.equals(quantity2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {

        QuantityMeasurementApp.QuantityLength quantity1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength quantity2 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(quantity1.equals(quantity2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {

        QuantityMeasurementApp.QuantityLength quantity1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength quantity2 =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(quantity1.equals(quantity2));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {

        QuantityMeasurementApp.QuantityLength quantity1 =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength quantity2 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(quantity1.equals(quantity2));
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        QuantityMeasurementApp.QuantityLength quantity1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength quantity2 =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(quantity1.equals(quantity2));
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {

        QuantityMeasurementApp.QuantityLength quantity1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength quantity2 =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertFalse(quantity1.equals(quantity2));
    }

    @Test
    void testEquality_SameReference() {

        QuantityMeasurementApp.QuantityLength quantity =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(quantity.equals(quantity));
    }

    @Test
    void testEquality_NullComparison() {

        QuantityMeasurementApp.QuantityLength quantity =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(quantity.equals(null));
    }

    @Test
    void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        null)
        );
    }

    @Test
    void testCheckLengthEquality() {

        assertTrue(
                QuantityMeasurementApp.checkLengthEquality(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH
                )
        );
    }
}