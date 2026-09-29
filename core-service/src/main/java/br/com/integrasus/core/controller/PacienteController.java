package br.com.integrasus.core.controller;

import br.com.integrasus.core.dto.PacienteRequest;
import br.com.integrasus.core.dto.PacienteResponse;
import br.com.integrasus.core.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
        name = "Pacientes",
        description = "Cadastro de pacientes atendidos pelo IntegraSUS Mental"
)
@RestController
@RequestMapping("/api/v1/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @Operation(
            summary = "Cadastrar paciente"
    )
    @PostMapping
    public ResponseEntity<PacienteResponse> criar(
            @Valid @RequestBody PacienteRequest request
    ) {

        PacienteResponse response =
                pacienteService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}