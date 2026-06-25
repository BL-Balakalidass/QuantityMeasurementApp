package com.app.quantitymeasurement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Quantity Measurement API",
				version = "1.0",
				description = "Spring Boot REST API for Quantity Measurement"
		)
)
public class QuantityMeasurementApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				QuantityMeasurementApplication.class,
				args
		);
	}
}