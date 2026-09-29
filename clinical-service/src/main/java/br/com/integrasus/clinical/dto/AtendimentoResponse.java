package br.com.integrasus.clinical.dto;

import br.com.integrasus.clinical.entity.StatusAtendimento;

public record AtendimentoResponse(
        Long atendimentoId,
        Long agendamentoId,
        Long pacienteId,
        StatusAtendimento status
) {
}