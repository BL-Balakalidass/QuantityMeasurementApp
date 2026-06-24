package main.java.entity;

import main.java.IMeasurable;
import main.java.Quantity;

public class QuantityEntity<U extends Enum<U> & IMeasurable> {

    private final Quantity<U> firstQuantity;
    private final Quantity<U> secondQuantity;
    private final U targetUnit;
    private final String operation;
    private final Object result;
    private final boolean error;
    private final String errorMessage;

    public QuantityEntity(
            Quantity<U> firstQuantity,
            Quantity<U> secondQuantity,
            U targetUnit,
            String operation) {

        this.firstQuantity = firstQuantity;
        this.secondQuantity = secondQuantity;
        this.targetUnit = targetUnit;
        this.operation = operation;
        this.result = null;
        this.error = false;
        this.errorMessage = null;
    }

    public QuantityEntity(Object result) {
        this.firstQuantity = null;
        this.secondQuantity = null;
        this.targetUnit = null;
        this.operation = null;
        this.result = result;
        this.error = false;
        this.errorMessage = null;
    }

    public QuantityEntity(String errorMessage) {
        this.firstQuantity = null;
        this.secondQuantity = null;
        this.targetUnit = null;
        this.operation = null;
        this.result = null;
        this.error = true;
        this.errorMessage = errorMessage;
    }

    public Quantity<U> getFirstQuantity() {
        return firstQuantity;
    }

    public Quantity<U> getSecondQuantity() {
        return secondQuantity;
    }

    public U getTargetUnit() {
        return targetUnit;
    }

    public String getOperation() {
        return operation;
    }

    public Object getResult() {
        return result;
    }

    public boolean hasError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}