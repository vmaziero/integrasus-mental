package br.com.integrasus.scheduling.dto;

import br.com.integrasus.scheduling.entity.AbordagemClinica;
import br.com.integrasus.scheduling.entity.ModalidadeAtendimento;
import br.com.integrasus.scheduling.entity.StatusVaga;

import java.time.LocalDateTime;

public record VagaResponse(
        Long id,
        Long instituicaoId,
        Long alunoId,
        Long supervisorId,
        LocalDateTime dataHora,
        ModalidadeAtendimento modalidade,
        AbordagemClinica abordagemClinica,
        String cep,
        StatusVaga status
) {
}