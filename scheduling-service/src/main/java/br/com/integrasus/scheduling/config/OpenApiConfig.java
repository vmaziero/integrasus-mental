package br.com.integrasus.scheduling.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI schedulingServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IntegraSUS Mental - Scheduling Service API")
                        .description(
                                "API responsável pela gestão de vagas, " +
                                        "agendamentos, cancelamentos e reabertura de vagas."
                        )
                        .version("v1"));
    }
}