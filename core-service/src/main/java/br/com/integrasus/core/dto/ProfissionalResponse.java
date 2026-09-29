package br.com.integrasus.core.dto;

import br.com.integrasus.core.entity.PerfilProfissional;

public record ProfissionalResponse(
        Long profissionalId,
        String nome,
        PerfilProfissional perfil,
        Long instituicaoId,
        Long supervisorId
) {
}