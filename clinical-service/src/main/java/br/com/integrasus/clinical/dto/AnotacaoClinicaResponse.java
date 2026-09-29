package br.com.integrasus.clinical.dto;

import br.com.integrasus.clinical.entity.StatusAtendimento;

public record AnotacaoClinicaResponse(
        Long anotacaoId,
        Long atendimentoId,
        StatusAtendimento statusAtendimento,
        String mensagem
) {
}