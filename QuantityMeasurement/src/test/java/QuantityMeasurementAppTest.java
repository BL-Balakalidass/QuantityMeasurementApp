package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.000001;


    @Test
    public void testConvertToBaseUnit_InchesToFeet() {

        assertEquals(
                1.0,
                LengthUnit.INCH.convertToBaseUnit(
                        12.0),
                0.001);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {

        assertEquals(
                12.0,
                LengthUnit.INCH.convertFromBaseUnit(
                        1.0),
                0.001);
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {

        QuantityLength length =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength result =
                length.convertTo(
                        LengthUnit.INCH);

        assertEquals(
                12.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inch =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCH);

        QuantityLength result =
                feet.add(
                        inch,
                        LengthUnit.YARD);

        assertEquals(
                0.666666,
                result.getValue(),
                0.001);
    }

    @Test
    public void testEquality_KilogramToGram() {

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        assertEquals(
                kilogram,
                gram);
    }

    @Test
    public void testConversion_KilogramToGram() {

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight result =
                kilogram.convertTo(
                        WeightUnit.GRAM);

        assertEquals(
                1000.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testAddition_KilogramPlusGram() {

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityWeight result =
                kilogram.add(gram);

        assertEquals(
                2.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testAddition_ExplicitTargetUnit() {

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityWeight result =
                kilogram.add(
                        gram,
                        WeightUnit.GRAM);

        assertEquals(
                2000.0,
                result.getValue(),
                0.001);
    }


}