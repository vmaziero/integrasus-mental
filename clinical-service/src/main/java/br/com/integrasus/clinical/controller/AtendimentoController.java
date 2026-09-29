package br.com.integrasus.clinical.controller;

import br.com.integrasus.clinical.dto.*;
import br.com.integrasus.clinical.service.AtendimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Atendimentos",
        description = "Fluxo clínico, anotações, supervisão e histórico do paciente"
)
@RestController
@RequestMapping("/api/v1/atendimentos")
@RequiredArgsConstructor
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    @Operation(
            summary = "Iniciar atendimento",
            description = "Cria um atendimento clínico vinculado a um agendamento."
    )
    @PostMapping
    public ResponseEntity<AtendimentoResponse> criar(
            @Valid @RequestBody AtendimentoRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(atendimentoService.criar(request));
    }

    @Operation(
            summary = "Registrar anotação clínica",
            description = "Registra a anotação feita pelo aluno e envia o atendimento para supervisão."
    )
    @PostMapping("/{id}/anotacoes")
    public ResponseEntity<AnotacaoClinicaResponse> registrarAnotacao(
            @PathVariable Long id,
            @Valid @RequestBody AnotacaoClinicaRequest request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        atendimentoService.registrarAnotacao(
                                id,
                                request
                        )
                );
    }

    @Operation(
            summary = "Avaliar anotação clínica",
            description = "Permite que o supervisor aprove ou revise a anotação registrada pelo aluno."
    )
    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<AprovacaoAnotacaoResponse> aprovarAnotacao(
            @PathVariable Long id,
            @Valid @RequestBody AprovacaoAnotacaoRequest request
    ) {

        return ResponseEntity.ok(
                atendimentoService.aprovarAnotacao(id, request)
        );
    }

    @Operation(
            summary = "Consultar histórico do paciente",
            description = "Retorna os atendimentos e respectivas informações clínicas vinculadas ao paciente."
    )
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<HistoricoAtendimentoResponse>> buscarHistoricoPaciente(
            @PathVariable Long pacienteId
    ) {

        return ResponseEntity.ok(
                atendimentoService.buscarHistoricoPaciente(pacienteId)
        );
    }
}