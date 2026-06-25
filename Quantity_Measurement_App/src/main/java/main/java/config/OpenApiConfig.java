package main.java.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Quantity Measurement API",
                version = "1.0",
                description = "Quantity Measurement Spring Boot API"
        )
)
public class OpenApiConfig {
}