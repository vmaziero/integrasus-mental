package br.com.integrasus.scheduling.dto;

import br.com.integrasus.scheduling.entity.StatusAgendamento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long agendamentoId,
        Long pacienteId,
        Long vagaId,
        LocalDateTime dataHora,
        StatusAgendamento status
) {
}