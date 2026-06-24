package main.java.exception;

public class QuantityServiceException
        extends RuntimeException {

    public QuantityServiceException(
            String message) {

        super(message);
    }
}