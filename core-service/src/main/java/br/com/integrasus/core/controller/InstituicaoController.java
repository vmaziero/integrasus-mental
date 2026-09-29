package br.com.integrasus.core.controller;

import br.com.integrasus.core.dto.InstituicaoRequest;
import br.com.integrasus.core.dto.InstituicaoResponse;
import br.com.integrasus.core.service.InstituicaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Instituições",
        description = "Cadastro e consulta de instituições parceiras"
)
@RestController
@RequestMapping("/api/v1/instituicoes")
@RequiredArgsConstructor
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    @Operation(
            summary = "Cadastrar instituição",
            description = "Cadastra uma nova clínica-escola ou instituição parceira."
    )
    @PostMapping
    public ResponseEntity<InstituicaoResponse> criar(
            @Valid @RequestBody InstituicaoRequest request
    ) {

        InstituicaoResponse response =
                instituicaoService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(
            summary = "Buscar instituição por ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoResponse> buscarPorId(
            @PathVariable Long id
    ) {

        InstituicaoResponse response =
                instituicaoService.buscarPorId(id);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Listar instituições"
    )
    @GetMapping
    public ResponseEntity<List<InstituicaoResponse>> listarTodas() {
        return ResponseEntity.ok(instituicaoService.listarTodas());
    }
}