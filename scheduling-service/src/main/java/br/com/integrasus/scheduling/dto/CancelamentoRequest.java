package br.com.integrasus.scheduling.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CancelamentoRequest(

        @Schema(
                example = "Paciente informou impossibilidade de comparecer.",
                description = "Motivo do cancelamento do agendamento"
        )
        @NotBlank
        String motivo

) {}