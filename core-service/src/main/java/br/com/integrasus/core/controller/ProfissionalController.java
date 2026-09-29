package br.com.integrasus.core.controller;

import br.com.integrasus.core.dto.ProfissionalRequest;
import br.com.integrasus.core.dto.ProfissionalResponse;
import br.com.integrasus.core.service.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Profissionais",
        description = "Cadastro de alunos e supervisores vinculados às instituições parceiras"
)
@RestController
@RequestMapping("/api/v1/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @Operation(
            summary = "Cadastrar profissional",
            description = "Cadastra um profissional com perfil ALUNO ou SUPERVISOR."
    )
    @PostMapping
    public ResponseEntity<ProfissionalResponse> criar(
            @Valid @RequestBody ProfissionalRequest request
    ) {

        ProfissionalResponse response =
                profissionalService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}