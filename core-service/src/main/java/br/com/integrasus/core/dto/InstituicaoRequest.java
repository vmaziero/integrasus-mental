package br.com.integrasus.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InstituicaoRequest(

        @Schema(example = "Clínica Escola FIAP")
        @NotBlank
        String razaoSocial,

        @Schema(example = "FIAP Psicologia")
        @NotBlank
        String nomeFantasia,

        @Schema(example = "12345678000199")
        @NotBlank
        @Size(min = 14, max = 14)
        String cnpj,

        @Schema(example = "11999999999")
        String telefoneContato,

        @Schema(example = "01310930")
        String cep,

        @Schema(example = "São Paulo")
        String cidade,

        @Schema(example = "SP")
        String estado,

        @Schema(example = "Avenida Paulista, 1000")
        String logradouro

) {}