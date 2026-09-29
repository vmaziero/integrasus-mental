package br.com.integrasus.clinical.dto;

import br.com.integrasus.clinical.entity.StatusAtendimento;

public record AprovacaoAnotacaoResponse(
        Long anotacaoId,
        Long atendimentoId,
        Boolean aprovado,
        StatusAtendimento statusAtendimento,
        String mensagem
) {
}