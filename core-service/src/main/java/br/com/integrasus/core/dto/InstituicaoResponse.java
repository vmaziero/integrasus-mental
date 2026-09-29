package br.com.integrasus.core.dto;

import br.com.integrasus.core.entity.StatusInstituicao;

public record InstituicaoResponse(
        Long instituicaoId,
        String nomeFantasia,
        StatusInstituicao status,
        String mensagem
) {
}