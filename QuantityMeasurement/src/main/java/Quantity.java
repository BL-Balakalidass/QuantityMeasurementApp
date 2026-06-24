package main.java;
import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 0.000001;

    private final double value;
    private final U unit;

    public Quantity(
            double value,
            U unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Invalid value");
        }

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {

            if (b == 0.0) {
                throw new ArithmeticException(
                        "Division by zero");
            }

            return a / b;
        });

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(
                DoubleBinaryOperator operator) {

            this.operator = operator;
        }

        public double compute(
                double left,
                double right) {

            return operator.applyAsDouble(
                    left,
                    right);
        }
    }

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (other.unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        if (!unit.getClass()
                .equals(other.unit.getClass())) {

            throw new IllegalArgumentException(
                    "Quantities belong to different measurement categories");
        }

        if (!Double.isFinite(value)
                || !Double.isFinite(other.value)) {

            throw new IllegalArgumentException(
                    "Quantity values must be finite");
        }

        if (targetUnitRequired) {

            if (targetUnit == null) {
                throw new IllegalArgumentException(
                        "Target unit cannot be null");
            }

            if (!unit.getClass()
                    .equals(targetUnit.getClass())) {

                throw new IllegalArgumentException(
                        "Target unit belongs to different measurement category");
            }
        }
    }

    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return operation.compute(
                thisBase,
                otherBase);
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }




    public Quantity<U> convertTo(
            U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    public Quantity<U> add(
            Quantity<U> other) {

        return add(other, unit);
    }
    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double resultBase =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.ADD);

        double converted =
                targetUnit.convertFromBaseUnit(
                        resultBase);

        converted =
                roundToTwoDecimals(converted);

        return new Quantity<>(
                converted,
                targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null ||
                getClass() != obj.getClass()) {
            return false;
        }

        Quantity<?> other =
                (Quantity<?>) obj;

        if (this.unit.getClass() !=
                other.unit.getClass()) {
            return false;
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(
                thisBase - otherBase)
                < EPSILON;
    }

    public Quantity<U> subtract(
            Quantity<U> other) {

        return subtract(other, unit);
    }
    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double resultBase =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double converted =
                targetUnit.convertFromBaseUnit(
                        resultBase);

        converted =
                roundToTwoDecimals(converted);

        return new Quantity<>(
                converted,
                targetUnit);
    }

//    private void validateCompatibleUnit(U targetUnit) {
//        if (targetUnit == null) {
//            throw new IllegalArgumentException("Target unit cannot be null");
//        }
//
//        if (!unit.getClass().equals(targetUnit.getClass())) {
//            throw new IllegalArgumentException(
//                    "Target unit must belong to the same measurement category");
//        }
//    }
    public double divide(
            Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false);

        return performBaseArithmetic(
                other,
                ArithmeticOperation.DIVIDE);
    }

//    private void validateQuantity(Quantity<U> other) {
//
//        if (other == null) {
//            throw new IllegalArgumentException(
//                    "Quantity cannot be null");
//        }
//
//        if (other.unit == null) {
//            throw new IllegalArgumentException(
//                    "Unit cannot be null");
//        }
//
//        if (!unit.getClass().equals(other.unit.getClass())) {
//            throw new IllegalArgumentException(
//                    "Incompatible measurement categories");
//        }
//
//        if (!Double.isFinite(value)
//                || !Double.isFinite(other.value)) {
//            throw new IllegalArgumentException(
//                    "Value must be finite");
//        }
//    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Double.hashCode(baseValue);
    }



    @Override
    public String toString() {

        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}