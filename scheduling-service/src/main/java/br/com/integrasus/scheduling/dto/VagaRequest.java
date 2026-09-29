package br.com.integrasus.scheduling.dto;

import br.com.integrasus.scheduling.entity.AbordagemClinica;
import br.com.integrasus.scheduling.entity.ModalidadeAtendimento;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record VagaRequest(

        @Schema(example = "1")
        @NotNull
        Long instituicaoId,

        @Schema(example = "2")
        @NotNull
        Long alunoId,

        @Schema(example = "1")
        @NotNull
        Long supervisorId,

        @Schema(
                example = "2026-10-05T14:00:00",
                description = "Data e hora futura da vaga"
        )
        @NotNull
        LocalDateTime dataHora,

        @Schema(example = "TELEMEDICINA")
        @NotNull
        ModalidadeAtendimento modalidade,

        @Schema(example = "TCC")
        @NotNull
        AbordagemClinica abordagemClinica,

        @Schema(
                example = "01310930",
                description = "Obrigatório para atendimento PRESENCIAL"
        )
        String cep

) {}