package main.java.service;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.entity.QuantityMeasurementEntity;
import main.java.repository.QuantityMeasurementRepository;

import java.util.List;

public class QuantityMeasurementServiceImpl
        implements QuantityMeasurementService {

    private final QuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(
            QuantityMeasurementRepository repository) {

        this.repository = repository;
    }

    @Override
    public void saveMeasurement(
            QuantityMeasurementEntity entity) {

        repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity>
    getAllMeasurements() {

        return repository.getAllMeasurements();
    }

    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByType(String type) {

        return repository.getMeasurementsByType(type);
    }

    @Override
    public int getTotalCount() {

        return repository.getTotalCount();
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