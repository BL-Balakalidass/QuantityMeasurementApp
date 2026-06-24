package main.java.repository;

import main.java.entity.QuantityMeasurementEntity;

import java.util.List;

public interface QuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

    List<QuantityMeasurementEntity>
    getMeasurementsByType(String type);

    List<QuantityMeasurementEntity>
    getMeasurementsByOperation(String operation);

    int getTotalCount();

    void deleteAll();
}