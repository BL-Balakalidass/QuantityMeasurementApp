package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.app.quantitymeasurement.service.QuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuantityMeasurementServiceImpl
        implements QuantityMeasurementService {

    @Override
    public QuantityMeasurementDTO compare(
            QuantityInputDTO input) {

        QuantityMeasurementDTO dto =
                new QuantityMeasurementDTO();

        dto.setResultString("Comparison Completed");

        return dto;
    }

    @Override
    public QuantityMeasurementDTO convert(
            QuantityInputDTO input) {

        QuantityMeasurementDTO dto =
                new QuantityMeasurementDTO();

        dto.setResultString("Conversion Completed");

        return dto;
    }

    @Override
    public QuantityMeasurementDTO add(
            QuantityInputDTO input) {

        QuantityMeasurementDTO dto =
                new QuantityMeasurementDTO();

        dto.setResultString("Addition Completed");

        return dto;
    }

    @Override
    public QuantityMeasurementDTO subtract(
            QuantityInputDTO input) {

        QuantityMeasurementDTO dto =
                new QuantityMeasurementDTO();

        dto.setResultString("Subtraction Completed");

        return dto;
    }

    @Override
    public QuantityMeasurementDTO divide(
            QuantityInputDTO input) {

        QuantityMeasurementDTO dto =
                new QuantityMeasurementDTO();

        dto.setResultString("Division Completed");

        return dto;
    }

    @Override
    public List<QuantityMeasurementDTO>
    getOperationHistory(String operation) {

        return new ArrayList<>();
    }

    @Override
    public List<QuantityMeasurementDTO>
    getMeasurementTypeHistory(String type) {

        return new ArrayList<>();
    }

    @Override
    public List<QuantityMeasurementDTO>
    getErroredHistory() {

        return new ArrayList<>();
    }

    @Override
    public long getOperationCount(String operation) {

        return 0;
    }
}