package com.isa.platform.u2021.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI ISAOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("ISA")
                        .description("ISA Connect REST API documentation.")
                        .version("v1.0.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("EGD"))
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("ISA Documentation")
                        .url("https://www.isaitaly.com/"));
    }
}
