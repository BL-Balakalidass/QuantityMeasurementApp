package main.java.controller;

import main.java.IMeasurable;
import main.java.LengthUnit;
import main.java.Quantity;
import main.java.entity.QuantityMeasurementEntity;
import main.java.service.QuantityMeasurementService;

public class QuantityMeasurementController {

    private final QuantityMeasurementService service;

    public QuantityMeasurementController(
            QuantityMeasurementService service) {

        this.service = service;
    }

    public void saveMeasurement(
            QuantityMeasurementEntity entity) {

        try {

            service.saveMeasurement(entity);

            System.out.println(
                    "Measurement Saved Successfully");

        } catch(Exception e) {

            System.out.println(
                    "Error : " + e.getMessage());
        }
    }

    public void displayAllMeasurements() {

        service.getAllMeasurements()
                .forEach(System.out::println);
    }

    public void displayMeasurementsByType(
            String type) {

        service.getMeasurementsByType(type)
                .forEach(System.out::println);
    }

    public Quantity<LengthUnit> add(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1) {
        return lengthUnitQuantity;
    }

    public double divide(Quantity<IMeasurable> iMeasurableQuantity, Quantity<LengthUnit> lengthUnitQuantity) {
        return 0;
    }

    public Quantity<LengthUnit> convert(Quantity<LengthUnit> lengthUnitQuantity, LengthUnit lengthUnit) {
        return lengthUnitQuantity;
    }

    public boolean compare(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1) {
        return false;
    }

    public Quantity<LengthUnit> subtract(Quantity<LengthUnit> lengthUnitQuantity, Quantity<IMeasurable> iMeasurableQuantity) {
        return lengthUnitQuantity;
    }
}