package br.com.integrasus.notification.event;

import java.time.LocalDateTime;

public record VagaReabertaEvent(
        Long vagaId,
        Long agendamentoId,
        LocalDateTime dataHora,
        String modalidade,
        String abordagemClinica
) {
}