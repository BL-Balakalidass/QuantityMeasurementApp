package test.java.service;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.entity.QuantityMeasurementEntity;
import main.java.repository.ConnectionPool;
import main.java.repository.QuantityMeasurementDatabaseRepository;
import main.java.service.QuantityMeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import main.java.service.QuantityMeasurementServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementServiceTest {

    private QuantityMeasurementService service;

    @BeforeEach
    void setup() {

        ConnectionPool connectionPool =
                new ConnectionPool(
                        "jdbc:h2:mem:testdb",
                        "sa",
                        "",
                        5
                );

        service =
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
                );
    }

    @Test
    void testCompareEquality() {

        boolean result =
                service.compare(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertTrue(result);
    }

    @Test
    void testConversion() {

        Quantity<LengthUnit> converted =
                service.convert(
                        new Quantity<>(1, LengthUnit.FEET),
                        LengthUnit.INCH
                );

        assertEquals(12.0, converted.getValue(), 0.001);
    }

    @Test
    void testAddition() {

        Quantity<LengthUnit> result =
                service.add(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertEquals(2.0, result.getValue(), 0.001);
    }

    @Test
    void testSubtraction() {

        Quantity<LengthUnit> result =
                service.subtract(
                        new Quantity<>(2, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCH)
                );

        assertEquals(1.0, result.getValue(), 0.001);
    }

    @Test
    void testDivision() {

        double result =
                service.divide(
                        new Quantity<>(24, LengthUnit.INCH),
                        new Quantity<>(2, LengthUnit.FEET)
                );

        assertEquals(1.0, result, 0.001);
    }
}