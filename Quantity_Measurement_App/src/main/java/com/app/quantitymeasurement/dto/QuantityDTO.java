package com.app.quantitymeasurement.dto;

import jakarta.validation.constraints.NotNull;

public class QuantityDTO {

    @NotNull
    private Double value;

    @NotNull
    private String unit;

    @NotNull
    private String measurementType;

    public QuantityDTO() {
    }

    public QuantityDTO(
            Double value,
            String unit,
            String measurementType) {

        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}