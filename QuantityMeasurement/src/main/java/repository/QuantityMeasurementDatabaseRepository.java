package main.java.repository;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.entity.QuantityMeasurementEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class QuantityMeasurementDatabaseRepository
        implements QuantityMeasurementRepository {

    private ConnectionPool pool;

    public QuantityMeasurementDatabaseRepository(
            ConnectionPool pool) {
        createTable();
    }

    private void createTable() {

        String sql =
                "CREATE TABLE IF NOT EXISTS quantity_measurement (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "measurement_type VARCHAR(50)," +
                        "operation VARCHAR(50)," +
                        "input VARCHAR(255)," +
                        "result VARCHAR(255)" +
                        ")";

        try {
            assert pool != null;
            try (Connection connection = pool.getConnection();
                 Statement statement = connection.createStatement()
            ) {

                statement.execute(sql);

            }
        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to create table",
                    e
            );
        }
    }
    @Override
    public void save(
            QuantityMeasurementEntity entity) {

        String sql = """
            INSERT INTO quantity_measurement
            (
              measurement_type,
              operation,
              input_value,
              result_value,
              timestamp
            )
            VALUES(?,?,?,?,?)
            """;

        Connection connection = pool.acquire();

        try(PreparedStatement statement =
                    connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    entity.getMeasurementType());

            statement.setString(
                    2,
                    entity.getOperation());

            statement.setString(
                    3,
                    entity.getInput());

            statement.setString(
                    4,
                    entity.getResult());

            statement.setTimestamp(
                    5,
                    Timestamp.valueOf(
                            entity.getTimestamp()));

            statement.executeUpdate();

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Save Failed",
                    e
            );

        } finally {

            pool.release(connection);
        }
    }

    public abstract void saveMeasurement(QuantityMeasurementEntity entity);

    @Override
    public List<QuantityMeasurementEntity>
    getAllMeasurements() {

        List<QuantityMeasurementEntity> entities =
                new ArrayList<>();

        String sql =
                "SELECT * FROM quantity_measurement";

        Connection connection = pool.acquire();

        try(PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs =
                    statement.executeQuery()) {

            while(rs.next()) {

                entities.add(
                        new QuantityMeasurementEntity(
                                rs.getString(
                                        "measurement_type"),
                                rs.getString(
                                        "operation"),
                                rs.getString(
                                        "input_value"),
                                rs.getString(
                                        "result_value")
                        )
                );
            }

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Read Failed",
                    e
            );

        } finally {

            pool.release(connection);
        }

        return entities;
    }

    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByType(String type) {

        return getAllMeasurements()
                .stream()
                .filter(entity ->
                        entity.getMeasurementType()
                                .equalsIgnoreCase(type))
                .toList();
    }

    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByOperation(
            String operation) {

        return getAllMeasurements()
                .stream()
                .filter(entity ->
                        entity.getOperation()
                                .equalsIgnoreCase(operation))
                .toList();
    }

    @Override
    public int getTotalCount() {
        return getAllMeasurements().size();
    }

    @Override
    public void deleteAll() {

        Connection connection = pool.acquire();

        try(Statement statement =
                    connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM quantity_measurement");

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Delete Failed",
                    e
            );

        } finally {

            pool.release(connection);
        }
    }

    public abstract double divide(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    public abstract Quantity<LengthUnit> add(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    public abstract boolean compare(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    public abstract Quantity<LengthUnit> subtract(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    public abstract Quantity<LengthUnit> convert(Quantity<LengthUnit> lengthUnitQuantity, LengthUnit lengthUnit);
}