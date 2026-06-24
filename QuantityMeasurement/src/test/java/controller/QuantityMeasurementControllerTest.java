package test.java.controller;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.controller.QuantityMeasurementController;
import main.java.entity.QuantityMeasurementEntity;
import main.java.repository.ConnectionPool;
import main.java.repository.QuantityMeasurementDatabaseRepository;
import main.java.service.QuantityMeasurementService;

import main.java.service.QuantityMeasurementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementControllerTest {

    private QuantityMeasurementController controller;

    @BeforeEach
    void setup() {

        ConnectionPool connectionPool =
                new ConnectionPool(
                        "jdbc:h2:mem:testdb",
                        "sa",
                        "",
                        5
                );

        controller =
                new QuantityMeasurementController(
                        new QuantityMeasurementServiceImpl(
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
                                }
                        )
                );
    }

    @Test
    void testEqualityThroughController() {

        boolean result =
                controller.compare(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertTrue(result);
    }

    @Test
    void testConversionThroughController() {

        Quantity<LengthUnit> converted =
                controller.convert(
                        new Quantity<>(1, LengthUnit.FEET),
                        LengthUnit.INCH
                );

        assertEquals(12.0, converted.getValue(), 0.001);
    }

    @Test
    void testAdditionThroughController() {

        Quantity<LengthUnit> result =
                controller.add(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertEquals(2.0, result.getValue(), 0.001);
    }

    @Test
    void testSubtractionThroughController() {

        Quantity<LengthUnit> result =
                controller.subtract(
                        new Quantity<>(2, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertEquals(1.0, result.getValue(), 0.001);
    }

    @Test
    void testDivisionThroughController() {

        double result =
                controller.divide(
                        new Quantity<>(24, LengthUnit.INCH),
                        new Quantity<>(2, LengthUnit.FEET)
                );

        assertEquals(1.0, result, 0.001);
    }
}