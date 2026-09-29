package br.com.integrasus.clinical.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AnotacaoClinicaRequest(

        @Schema(
                example = "Paciente relata ansiedade intensa e dificuldade para dormir."
        )
        @NotBlank
        String queixaPrincipal,

        @Schema(
                example = "Paciente apresentou boa adesão à sessão e conseguiu identificar gatilhos relacionados ao trabalho."
        )
        @NotBlank
        String evolucao,

        @Schema(
                example = "Quadro compatível com sintomas ansiosos."
        )
        String hipoteseDiagnostica,

        @Schema(
                example = "BAIXO"
        )
        String nivelRisco

) {}