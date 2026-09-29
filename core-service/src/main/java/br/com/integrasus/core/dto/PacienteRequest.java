package br.com.integrasus.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PacienteRequest(

        @Schema(example = "Ana Oliveira")
        @NotBlank
        String nomeCompleto,

        @Schema(example = "11122233344")
        @NotBlank
        String cpf,

        @Schema(example = "898001234567890")
        @NotBlank
        String numeroCartaoSus,

        @Schema(example = "1995-06-15")
        LocalDate dataNascimento,

        @Schema(example = "11988887777")
        String telefoneCelular,

        @Schema(example = "ana.oliveira@email.com")
        String email,

        @Schema(example = "true")
        Boolean aceitaNotificacaoSms,

        @Schema(example = "01310930")
        String cep,

        @Schema(example = "São Paulo")
        String cidade,

        @Schema(example = "SP")
        String estado,

        @Schema(
                example = "Ansiedade e dificuldade para dormir"
        )
        String necessidadeClinica

) {}