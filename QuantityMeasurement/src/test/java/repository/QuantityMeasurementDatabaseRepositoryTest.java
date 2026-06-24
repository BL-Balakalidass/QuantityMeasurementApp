package test.java.repository;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.repository.ConnectionPool;
import main.java.repository.QuantityMeasurementDatabaseRepository;
//import main.java.repository.QuantityMeasurementEntity;
import org.junit.jupiter.api.BeforeEach;
import main.java.entity.QuantityMeasurementEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementDatabaseRepositoryTest {

    private QuantityMeasurementDatabaseRepository repository;

    @BeforeEach
    void setup() {

        ConnectionPool connectionPool =
                new ConnectionPool(
                        "jdbc:h2:mem:testdb",
                        "sa",
                        "",
                        5
                );

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
    }

    @Test
    void testSaveEntity() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        "1 FEET",
                        "12 INCHES",
                        "true"
                );

        repository.save(entity);

        assertEquals(1, repository.getTotalCount());
    }

    @Test
    void testRetrieveAllMeasurements() {

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        "1 FEET",
                        "12 INCHES",
                        "true"
                ));

        repository.save(
                new QuantityMeasurementEntity(
                        "CONVERT",
                        "WEIGHT",
                        "1 KG",
                        "",
                        "1000 GRAM"
                ));

        List<QuantityMeasurementEntity> entities =
                repository.getAllMeasurements();

        assertEquals(2, entities.size());
    }

    @Test
    void testQueryByOperation() {

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        "1 FEET",
                        "12 INCHES",
                        "true"
                ));

        repository.save(
                new QuantityMeasurementEntity(
                        "CONVERT",
                        "WEIGHT",
                        "1 KG",
                        "",
                        "1000 GRAM"
                ));

        assertEquals(
                1,
                repository.getMeasurementsByOperation("COMPARE").size()
        );
    }

    @Test
    void testDeleteAll() {

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        "1 FEET",
                        "12 INCHES",
                        "true"
                ));

        repository.deleteAll();

        assertEquals(0, repository.getTotalCount());
    }

    @Test
    void testCountMeasurements() {

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        "1 FEET",
                        "12 INCHES",
                        "true"
                ));

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        "2 FEET",
                        "24 INCHES",
                        "true"
                ));

        assertEquals(2, repository.getTotalCount());
    }
}