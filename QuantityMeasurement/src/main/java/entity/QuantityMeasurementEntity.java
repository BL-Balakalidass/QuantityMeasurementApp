package main.java.entity;

import java.time.LocalDateTime;

public class QuantityMeasurementEntity {

    private final String operation;
    private final String measurementType;
    private final String input;
    private final String result;
    private final boolean error;
    private final String errorMessage;
    private final LocalDateTime timestamp;

    // Success Constructor
    public QuantityMeasurementEntity(
            String operation,
            String measurementType,
            String input,
            String result,
            String error) {

        this.operation = operation;
        this.measurementType = measurementType;
        this.input = input;
        this.result = result;
        this.error = Boolean.parseBoolean(error);
        this.errorMessage = null;
        this.timestamp = LocalDateTime.now();
    }

    // Error Constructor
    public QuantityMeasurementEntity(
            String operation,
            String measurementType,
            String input,
            String errorMessage) {

        this.operation = operation;
        this.measurementType = measurementType;
        this.input = input;
        this.result = null;
        this.error = true;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDateTime.now();
    }

    public String getOperation() {
        return operation;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public String getInput() {
        return input;
    }

    public String getResult() {
        return result;
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        if (error) {
            return "QuantityMeasurementEntity{" +
                    "operation='" + operation + '\'' +
                    ", measurementType='" + measurementType + '\'' +
                    ", input='" + input + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    ", timestamp=" + timestamp +
                    '}';
        }

        return "QuantityMeasurementEntity{" +
                "operation='" + operation + '\'' +
                ", measurementType='" + measurementType + '\'' +
                ", input='" + input + '\'' +
                ", result='" + result + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}