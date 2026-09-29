package br.com.integrasus.scheduling.controller;

import br.com.integrasus.scheduling.dto.AgendamentoRequest;
import br.com.integrasus.scheduling.dto.AgendamentoResponse;
import br.com.integrasus.scheduling.dto.CancelamentoRequest;
import br.com.integrasus.scheduling.dto.CancelamentoResponse;
import br.com.integrasus.scheduling.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
        name = "Agendamentos",
        description = "Operações de criação, consulta e cancelamento de agendamentos"
)
@RestController
@RequestMapping("/api/v1/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Operation(
            summary = "Criar agendamento",
            description = "Reserva uma vaga disponível para um paciente."
    )
    @PostMapping
    public ResponseEntity<AgendamentoResponse> criar(
            @Valid @RequestBody AgendamentoRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agendamentoService.criar(request));
    }

    @Operation(
            summary = "Cancelar agendamento",
            description = "Cancela o agendamento, reabre a vaga e publica um evento no RabbitMQ."
    )
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<CancelamentoResponse> cancelar(
            @PathVariable Long id,
            @Valid @RequestBody CancelamentoRequest request
    ) {

        return ResponseEntity.ok(
                agendamentoService.cancelar(id, request)
        );
    }

    @Operation(
            summary = "Buscar agendamento por ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                agendamentoService.buscarPorId(id)
        );
    }
}