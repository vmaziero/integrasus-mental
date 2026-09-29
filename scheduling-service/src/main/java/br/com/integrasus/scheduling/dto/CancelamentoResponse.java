package br.com.integrasus.scheduling.dto;

import br.com.integrasus.scheduling.entity.StatusAgendamento;
import br.com.integrasus.scheduling.entity.StatusVaga;

public record CancelamentoResponse(
        Long agendamentoId,
        StatusAgendamento statusAgendamento,
        Long vagaId,
        StatusVaga statusVaga,
        String mensagem
) {
}