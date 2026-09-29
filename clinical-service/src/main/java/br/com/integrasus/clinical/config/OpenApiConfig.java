package br.com.integrasus.clinical.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI clinicalServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IntegraSUS Mental - Clinical Service API")
                        .description(
                                "API responsável pelo atendimento clínico, " +
                                        "registro de anotações, supervisão acadêmica " +
                                        "e histórico dos pacientes."
                        )
                        .version("v1"));
    }
}