package br.com.integrasus.scheduling.exception;

import java.time.LocalDateTime;

public record ErroResponse(
        LocalDateTime timestamp,
        int status,
        String erro,
        String mensagem
) {
}