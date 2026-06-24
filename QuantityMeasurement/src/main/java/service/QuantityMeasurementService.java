package main.java.service;

import main.java.LengthUnit;
import main.java.Quantity;
import main.java.entity.QuantityMeasurementEntity;

import java.util.List;

public interface QuantityMeasurementService {

    void saveMeasurement(
            QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity>
    getAllMeasurements();

    List<QuantityMeasurementEntity>
    getMeasurementsByType(String type);

    int getTotalCount();

    double divide(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    Quantity<LengthUnit> add(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    boolean compare(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    Quantity<LengthUnit> subtract(Quantity<LengthUnit> lengthUnitQuantity, Quantity<LengthUnit> lengthUnitQuantity1);

    Quantity<LengthUnit> convert(Quantity<LengthUnit> lengthUnitQuantity, LengthUnit lengthUnit);
}