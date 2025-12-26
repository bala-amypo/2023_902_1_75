package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // API metadata
                .info(new Info()
                        .title("Visitor Risk Scoring API")
                        .version("1.0")
                        .description("Backend API documentation for Visitor Risk Scoring Engine"))
                // Server configuration
                .servers(List.of(
                        new Server().url("https://9038.408procr.amypo.ai/")
                ));
    }
}
