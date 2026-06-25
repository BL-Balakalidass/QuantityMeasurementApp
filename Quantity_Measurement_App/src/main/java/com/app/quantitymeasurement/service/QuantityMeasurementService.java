package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;

import java.util.List;

public interface QuantityMeasurementService {

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO convert(QuantityInputDTO input);

    QuantityMeasurementDTO add(QuantityInputDTO input);

    QuantityMeasurementDTO subtract(QuantityInputDTO input);

    QuantityMeasurementDTO divide(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getOperationHistory(String operation);

    List<QuantityMeasurementDTO> getMeasurementTypeHistory(String type);

    List<QuantityMeasurementDTO> getErroredHistory();

    long getOperationCount(String operation);
}