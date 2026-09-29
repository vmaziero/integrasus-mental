package br.com.integrasus.clinical.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record AtendimentoRequest(

        @Schema(example = "1")
        @NotNull
        Long agendamentoId,

        @Schema(example = "1")
        @NotNull
        Long pacienteId,

        @Schema(example = "2")
        @NotNull
        Long alunoId,

        @Schema(example = "1")
        @NotNull
        Long supervisorId

) {}