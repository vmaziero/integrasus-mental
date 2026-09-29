package br.com.integrasus.core.dto;

import br.com.integrasus.core.entity.PerfilProfissional;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfissionalRequest(

        @Schema(example = "Victoria Maziero")
        @NotBlank
        String nome,

        @Schema(example = "12345678901")
        @NotBlank
        String cpf,

        @Schema(example = "victoria.maziero@fiap.com.br")
        @NotBlank
        String email,

        @Schema(example = "ALUNO")
        @NotNull
        PerfilProfissional perfil,

        @Schema(example = "1")
        @NotNull
        Long instituicaoId,

        @Schema(
                example = "RM123456",
                description = "Obrigatório para profissionais com perfil ALUNO"
        )
        String matricula,

        @Schema(
                example = "8",
                description = "Semestre atual do aluno"
        )
        Integer semestre,

        @Schema(
                example = "1",
                description = "ID do supervisor responsável. Obrigatório para ALUNO."
        )
        Long supervisorId

) {}