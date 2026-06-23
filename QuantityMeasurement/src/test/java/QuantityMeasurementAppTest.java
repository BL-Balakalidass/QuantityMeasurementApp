package test.java;

import main.java.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToYard_SameValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        1.0,
                                        QuantityMeasurementApp.LengthUnit.YARD)
                        )
        );
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {

        assertFalse(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        2.0,
                                        QuantityMeasurementApp.LengthUnit.YARD)
                        )
        );
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        3.0,
                                        QuantityMeasurementApp.LengthUnit.FEET)
                        )
        );
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        1.0,
                                        QuantityMeasurementApp.LengthUnit.YARD)
                        )
        );
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        36.0,
                                        QuantityMeasurementApp.LengthUnit.INCH)
                        )
        );
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        36.0,
                        QuantityMeasurementApp.LengthUnit.INCH)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        1.0,
                                        QuantityMeasurementApp.LengthUnit.YARD)
                        )
        );
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {

        assertFalse(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        2.0,
                                        QuantityMeasurementApp.LengthUnit.FEET)
                        )
        );
    }

    @Test
    void testEquality_CentimeterToCentimeter_SameValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        2.0,
                                        QuantityMeasurementApp.LengthUnit.CENTIMETER)
                        )
        );
    }

    @Test
    void testEquality_CentimeterToInches_EquivalentValue() {

        assertTrue(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        0.393701,
                                        QuantityMeasurementApp.LengthUnit.INCH)
                        )
        );
    }

    @Test
    void testEquality_CentimeterToFeet_NonEquivalentValue() {

        assertFalse(
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(
                                        1.0,
                                        QuantityMeasurementApp.LengthUnit.FEET)
                        )
        );
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD);

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        36.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_YardWithNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        null)
        );
    }

    @Test
    void testEquality_YardSameReference() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertTrue(yard.equals(yard));
    }

    @Test
    void testEquality_YardNullComparison() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertFalse(yard.equals(null));
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.YARD);

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        6.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        72.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }
}