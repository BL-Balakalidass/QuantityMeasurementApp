package main.java;

public interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    default SupportsArithmetic getArithmeticSupport() {
        return () -> true;
    }

    default boolean supportsArithmetic() {
        return getArithmeticSupport().isSupported();
    }

    default void validateOperationSupport(String operation) {
        // Default = all arithmetic supported
    }
}