package br.com.integrasus.scheduling.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record AgendamentoRequest(

        @Schema(example = "1")
        @NotNull
        Long vagaId,

        @Schema(example = "1")
        @NotNull
        Long pacienteId

) {}