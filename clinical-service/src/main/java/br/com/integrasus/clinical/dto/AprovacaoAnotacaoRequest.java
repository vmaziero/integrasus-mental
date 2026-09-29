package br.com.integrasus.clinical.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AprovacaoAnotacaoRequest(

        @Schema(example = "true")
        @NotNull
        Boolean aprovado,

        @Schema(
                example = "Anotação adequada. Conduta e registro clínico compatíveis com o atendimento realizado."
        )
        @NotBlank
        String parecerSupervisor

) {}