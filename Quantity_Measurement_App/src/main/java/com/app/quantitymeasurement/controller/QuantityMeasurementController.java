package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.app.quantitymeasurement.service.QuantityMeasurementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
@Tag(
        name = "Quantity Measurements",
        description =
                "REST API for quantity measurement operations"
)
@RequiredArgsConstructor
public class QuantityMeasurementController {

    private final QuantityMeasurementService service;

    @PostMapping("/compare")
    @Operation(summary = "Compare two quantities")
    public QuantityMeasurementDTO compare(
            @RequestBody QuantityInputDTO input) {

        return service.compare(input);
    }

    @PostMapping("/convert")
    @Operation(summary = "Convert quantity")
    public QuantityMeasurementDTO convert(
            @RequestBody QuantityInputDTO input) {

        return service.convert(input);
    }

    @PostMapping("/add")
    @Operation(summary = "Add quantities")
    public QuantityMeasurementDTO add(
            @RequestBody QuantityInputDTO input) {

        return service.add(input);
    }

    @PostMapping("/subtract")
    @Operation(summary = "Subtract quantities")
    public QuantityMeasurementDTO subtract(
            @RequestBody QuantityInputDTO input) {

        return service.subtract(input);
    }

    @PostMapping("/divide")
    @Operation(summary = "Divide quantities")
    public QuantityMeasurementDTO divide(
            @RequestBody QuantityInputDTO input) {

        return service.divide(input);
    }

    @GetMapping("/history/operation/{operation}")
    public List<QuantityMeasurementDTO>
    getOperationHistory(
            @PathVariable String operation) {

        return service.getOperationHistory(
                operation);
    }

    @GetMapping("/history/type/{type}")
    public List<QuantityMeasurementDTO>
    getByType(
            @PathVariable String type) {

        return service.getMeasurementTypeHistory(
                type);
    }

    @GetMapping("/history/errored")
    public List<QuantityMeasurementDTO>
    getErroredHistory() {

        return service.getErroredHistory();
    }

    @GetMapping("/count/{operation}")
    public long count(
            @PathVariable String operation) {

        return service.getOperationCount(
                operation);
    }
}