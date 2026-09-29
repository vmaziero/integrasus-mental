package br.com.integrasus.scheduling.controller;

import br.com.integrasus.scheduling.dto.VagaRequest;
import br.com.integrasus.scheduling.dto.VagaResponse;
import br.com.integrasus.scheduling.service.VagaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Vagas",
        description = "Gestão das vagas disponibilizadas pelas clínicas-escola"
)
@RestController
@RequestMapping("/api/v1/vagas")
@RequiredArgsConstructor
public class VagaController {

    private final VagaService vagaService;

    @Operation(
            summary = "Criar vaga",
            description = "Disponibiliza uma nova vaga para atendimento psicológico."
    )
    @PostMapping
    public ResponseEntity<VagaResponse> criar(
            @Valid @RequestBody VagaRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vagaService.criar(request));
    }

    @Operation(
            summary = "Listar vagas",
            description = "Lista as vagas cadastradas no sistema."
    )
    @GetMapping
    public ResponseEntity<List<VagaResponse>> listarTodas() {
        return ResponseEntity.ok(vagaService.listarTodas());
    }
}