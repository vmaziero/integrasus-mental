package br.com.integrasus.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI coreServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IntegraSUS Mental - Core Service API")
                        .description(
                                "API responsável pelo cadastro de instituições parceiras, " +
                                        "profissionais e pacientes do IntegraSUS Mental."
                        )
                        .version("v1"));
    }
}