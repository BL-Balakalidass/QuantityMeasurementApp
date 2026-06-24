package main.java;

import main.java.controller.QuantityMeasurementController;
import main.java.entity.QuantityMeasurementEntity;
import main.java.repository.ConnectionPool;
import main.java.repository.QuantityMeasurementDatabaseRepository;
import main.java.repository.QuantityMeasurementRepository;
import main.java.service.QuantityMeasurementService;
import main.java.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        ConnectionPool pool =
                new ConnectionPool(5);

        QuantityMeasurementRepository repository =
                new QuantityMeasurementDatabaseRepository(
                        pool) {
                    @Override
                    public void saveMeasurement(QuantityMeasurementEntity entity) {

                    }

                    @Override
                    public double divide(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1) {
                        return 0;
                    }

                    @Override
                    public Quantity<LengthUnit> add(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1) {
                        return null;
                    }

                    @Override
                    public boolean compare(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1) {
                        return false;
                    }

                    @Override
                    public Quantity<LengthUnit> subtract(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1) {
                        return null;
                    }

                    @Override
                    public Quantity<LengthUnit> convert(Quantity<LengthUnit> lengthUnitQuantity, LengthUnit lengthUnit) {
                        return null;
                    }
                };

        QuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(
                        repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(
                        service);

        System.out.println(
                "Example 1: Saving Quantity Comparison");

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        "Length",
                        "Comparison",
                        "1 FEET vs 12 INCHES",
                        "TRUE");

        controller.saveMeasurement(entity);

        System.out.println(
                "\nExample 2: Retrieving Measurements");

        controller.displayMeasurementsByType(
                "Length");

        System.out.println(
                "\nExample 3: Connection Pool Management");

        System.out.println(
                "Available Connections = "
                        + pool.availableConnections());
    }
}