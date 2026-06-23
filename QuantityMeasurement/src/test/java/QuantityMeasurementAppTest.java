package test.java;

import main.java.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // --------------------------
    // FEET TESTS
    // --------------------------

    @Test
    void testFeetEquality_SameValue() {

        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(1.0);

        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_DifferentValue() {

        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(1.0);

        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(2.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_NullComparison() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_NonNumericInput() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals("1.0"));
    }

    @Test
    void testFeetEquality_SameReference() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet));
    }

    // --------------------------
    // INCHES TESTS
    // --------------------------

    @Test
    void testInchesEquality_SameValue() {

        QuantityMeasurementApp.Inches inches1 =
                new QuantityMeasurementApp.Inches(1.0);

        QuantityMeasurementApp.Inches inches2 =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches2));
    }

    @Test
    void testInchesEquality_DifferentValue() {

        QuantityMeasurementApp.Inches inches1 =
                new QuantityMeasurementApp.Inches(1.0);

        QuantityMeasurementApp.Inches inches2 =
                new QuantityMeasurementApp.Inches(2.0);

        assertFalse(inches1.equals(inches2));
    }

    @Test
    void testInchesEquality_NullComparison() {

        QuantityMeasurementApp.Inches inches =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inches.equals(null));
    }

    @Test
    void testInchesEquality_NonNumericInput() {

        QuantityMeasurementApp.Inches inches =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inches.equals("1.0"));
    }

    @Test
    void testInchesEquality_SameReference() {

        QuantityMeasurementApp.Inches inches =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches.equals(inches));
    }

    // --------------------------
    // STATIC METHOD TESTS
    // --------------------------

    @Test
    void testCheckFeetEquality() {

        assertTrue(
                QuantityMeasurementApp
                        .checkFeetEquality(1.0, 1.0)
        );
    }

    @Test
    void testCheckInchesEquality() {

        assertTrue(
                QuantityMeasurementApp
                        .checkInchesEquality(1.0, 1.0)
        );
    }
}