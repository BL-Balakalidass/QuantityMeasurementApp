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


    @Test
    public void testGenericQuantity_LengthEquality() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);

        assertEquals(
                feet,
                inch);
    }

    @Test
    public void testGenericQuantity_WeightEquality() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);

        assertEquals(
                kilogram,
                gram);
    }

    @Test
    public void testGenericQuantity_LengthConversion() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(
                        LengthUnit.INCH);

        assertEquals(
                12.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testGenericQuantity_WeightConversion() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kilogram.convertTo(
                        WeightUnit.GRAM);

        assertEquals(
                1000.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testGenericQuantity_LengthAddition() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);

        Quantity<LengthUnit> result =
                feet.add(
                        inch,
                        LengthUnit.FEET);

        assertEquals(
                2.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testGenericQuantity_WeightAddition() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kilogram.add(
                        gram,
                        WeightUnit.KILOGRAM);

        assertEquals(
                2.0,
                result.getValue(),
                0.001);
    }

    @Test
    public void testCrossCategoryPrevention() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(
                feet.equals(kilogram));
    }

    @Test
    void testSubtraction_SameUnit_FeetMinusFeet() {

        Quantity<LengthUnit> result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(5.0,
                                        LengthUnit.FEET));

        assertEquals(
                new Quantity<>(5.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testSubtraction_CrossUnit_FeetMinusInches() {

        Quantity<LengthUnit> result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(6.0,
                                        LengthUnit.INCH));

        assertEquals(
                new Quantity<>(9.5,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Inches() {

        Quantity<LengthUnit> result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(6.0,
                                        LengthUnit.INCH),
                                LengthUnit.INCH);

        assertEquals(
                new Quantity<>(114.0,
                        LengthUnit.INCH),
                result);
    }

    @Test
    void testSubtraction_ResultingInNegative() {

        Quantity<LengthUnit> result =
                new Quantity<>(5.0,
                        LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(10.0,
                                        LengthUnit.FEET));

        assertEquals(
                new Quantity<>(-5.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testSubtraction_ResultingInZero() {

        Quantity<LengthUnit> result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(120.0,
                                        LengthUnit.INCH));

        assertEquals(
                new Quantity<>(0.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testDivision_SameUnit_FeetDividedByFeet() {

        double result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .divide(
                                new Quantity<>(2.0,
                                        LengthUnit.FEET));

        assertEquals(5.0, result, EPSILON);
    }

    @Test
    void testDivision_CrossUnit_FeetDividedByInches() {

        double result =
                new Quantity<>(24.0,
                        LengthUnit.INCH)
                        .divide(
                                new Quantity<>(2.0,
                                        LengthUnit.FEET));

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testDivision_ByZero() {

        assertThrows(
                ArithmeticException.class,
                () -> new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .divide(
                                new Quantity<>(0.0,
                                        LengthUnit.FEET)));
    }

    @Test
    @SuppressWarnings({"rawtypes","unchecked"})
    void testSubtraction_CrossCategory() {

        Quantity length =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity weight =
                new Quantity<>(5.0,
                        WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.subtract(weight));
    }

    @Test
    void testSubtraction_Immutability() {

        Quantity<LengthUnit> original =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> other =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                original.subtract(other);

        assertEquals(
                new Quantity<>(10.0,
                        LengthUnit.FEET),
                original);

        assertEquals(
                new Quantity<>(5.0,
                        LengthUnit.FEET),
                other);

        assertEquals(
                new Quantity<>(5.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testArithmeticOperation_Add_EnumComputation() {

        assertEquals(
                15.0,
                Quantity.ArithmeticOperation.ADD.compute(
                        10.0,
                        5.0));
    }

    @Test
    void testArithmeticOperation_Divide_EnumComputation() {

        assertEquals(
                2.0,
                Quantity.ArithmeticOperation.DIVIDE.compute(
                        10.0,
                        5.0));
    }


    @Test
    void testArithmeticOperation_DivideByZero_EnumThrows() {

        assertThrows(
                ArithmeticException.class,
                () -> Quantity.ArithmeticOperation.DIVIDE.compute(
                        10.0,
                        0.0));
    }

    @Test
    void testValidation_NullOperand_ConsistentAcrossOperations() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.add(null));

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.subtract(null));

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.divide(null));
    }

    @Test
    void testValidation_CrossCategory_ConsistentAcrossOperations() {

        Quantity length =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity weight =
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(weight));

        assertThrows(
                IllegalArgumentException.class,
                () -> length.subtract(weight));

        assertThrows(
                IllegalArgumentException.class,
                () -> length.divide(weight));
    }

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(
                celsius,
                fahrenheit);
    }

    @Test
    void testTemperatureConversion_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(
                212.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testTemperatureConversion_FahrenheitToCelsius() {

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                fahrenheit.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testTemperatureConversion_KelvinToCelsius() {

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN);

        Quantity<TemperatureUnit> result =
                kelvin.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testTemperatureUnsupportedOperation_Add() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    @Test
    void testTemperatureUnsupportedOperation_Subtract() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    @Test
    void testTemperatureUnsupportedOperation_Divide() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }

    @Test
    void testTemperatureVsLength() {

        Quantity temperature =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity length =
                new Quantity<>(
                        100.0,
                        LengthUnit.FEET);

        assertNotEquals(
                temperature,
                length);
    }

}