package main.java.controller;

import main.java.IMeasurable;
import main.java.entity.QuantityEntity;
import main.java.service.QuantityService;

public class QuantityController {

    private final QuantityService quantityService;

    public QuantityController(
            QuantityService quantityService) {

        if (quantityService == null) {
            throw new IllegalArgumentException(
                    "Quantity Service cannot be null");
        }

        this.quantityService = quantityService;
    }

    public <U extends Enum<U> & IMeasurable>
    void add(QuantityEntity<U> entity) {

        display(
                quantityService.add(entity));
    }

    public <U extends Enum<U> & IMeasurable>
    void subtract(QuantityEntity<U> entity) {

        display(
                quantityService.subtract(entity));
    }

    public <U extends Enum<U> & IMeasurable>
    void divide(QuantityEntity<U> entity) {

        display(
                quantityService.divide(entity));
    }

    public <U extends Enum<U> & IMeasurable>
    void convert(QuantityEntity<U> entity) {

        display(
                quantityService.convert(entity));
    }

    public <U extends Enum<U> & IMeasurable>
    void compare(QuantityEntity<U> entity) {

        display(
                quantityService.compare(entity));
    }

    private <U extends Enum<U> & IMeasurable>
    void display(QuantityEntity<U> entity) {

        if (entity.hasError()) {

            System.out.println(
                    "ERROR : " +
                            entity.getErrorMessage());

            return;
        }

        System.out.println(
                "RESULT : " +
                        entity.getResult());
    }
}