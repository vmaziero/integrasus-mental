package br.com.integrasus.core.dto;

public record PacienteResponse(
        Long pacienteId,
        String nomeCompleto,
        String numeroCartaoSus,
        String statusIntegracao
) {
}