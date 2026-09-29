package br.com.integrasus.clinical.dto;

import br.com.integrasus.clinical.entity.StatusAtendimento;

import java.time.LocalDateTime;

public record HistoricoAtendimentoResponse(
        Long atendimentoId,
        Long agendamentoId,
        Long alunoId,
        Long supervisorId,
        StatusAtendimento status,
        LocalDateTime criadoEm,
        String queixaPrincipal,
        String evolucao,
        String hipoteseDiagnostica,
        String nivelRisco,
        Boolean aprovado,
        String parecerSupervisor
) {
}