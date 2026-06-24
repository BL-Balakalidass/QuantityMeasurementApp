package test.java.integrationTests;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.controller.QuantityMeasurementController;
import main.java.entity.QuantityMeasurementEntity;
import main.java.repository.QuantityMeasurementDatabaseRepository;
import main.java.service.QuantityMeasurementService;
import main.java.repository.ConnectionPool;
import main.java.service.QuantityMeasurementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementIntegrationTest {

    private QuantityMeasurementController controller;
    private QuantityMeasurementDatabaseRepository repository;

    @BeforeEach
    void setup() {

        ConnectionPool connectionPool = null;
//        ConnectionPool connectionPool;
        repository =
                new QuantityMeasurementDatabaseRepository(
                        connectionPool
                ) {
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

        controller =
                new QuantityMeasurementController(
                        new QuantityMeasurementServiceImpl(
                                repository) {
                            @Override
                            public void saveMeasurement(QuantityMeasurementEntity entity) {

                            }

                            @Override
                            public List<QuantityMeasurementEntity> getAllMeasurements() {
                                return List.of();
                            }

                            @Override
                            public List<QuantityMeasurementEntity> getMeasurementsByType(String type) {
                                return List.of();
                            }

                            @Override
                            public int getTotalCount() {
                                return 0;
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
                        }
                );

        repository.deleteAll();
    }

    @Test
    void testEndToEnd_LengthComparison() {

        boolean result =
                controller.compare(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertTrue(result);

        assertEquals(
                1,
                repository.getTotalCount()
        );
    }

    @Test
    void testEndToEnd_LengthConversion() {

        Quantity<LengthUnit> converted =
                controller.convert(
                        new Quantity<>(1, LengthUnit.FEET),
                        LengthUnit.INCH
                );

        assertEquals(
                12.0,
                converted.getValue(),
                0.001
        );

        assertEquals(
                1,
                repository.getTotalCount()
        );
    }

    @Test
    void testEndToEnd_Addition() {

        Quantity<LengthUnit> result =
                controller.add(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertEquals(
                2.0,
                result.getValue(),
                0.001
        );

        assertEquals(
                1,
                repository.getTotalCount()
        );
    }

    @Test
    void testEndToEnd_Subtraction() {

        Quantity<LengthUnit> result =
                controller.subtract(
                        new Quantity<>(2, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertEquals(
                1.0,
                result.getValue(),
                0.001
        );

        assertEquals(
                1,
                repository.getTotalCount()
        );
    }

    @Test
    void testEndToEnd_Division() {

        double result =
                controller.divide(
                        new Quantity<>(24, LengthUnit.INCH),
                        new Quantity<>(2, LengthUnit.FEET)
                );

        assertEquals(
                1.0,
                result,
                0.001
        );

        assertEquals(
                1,
                repository.getTotalCount()
        );
    }
}