package br.com.integrasus.scheduling.service;

import br.com.integrasus.scheduling.dto.VagaRequest;
import br.com.integrasus.scheduling.dto.VagaResponse;
import br.com.integrasus.scheduling.entity.ModalidadeAtendimento;
import br.com.integrasus.scheduling.entity.StatusVaga;
import br.com.integrasus.scheduling.entity.Vaga;
import br.com.integrasus.scheduling.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaResponse criar(VagaRequest request) {

        if (request.dataHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "A data e hora da vaga devem estar no futuro."
            );
        }

        if (request.modalidade() == ModalidadeAtendimento.PRESENCIAL
                && (request.cep() == null || request.cep().isBlank())) {
            throw new IllegalArgumentException(
                    "CEP é obrigatório para atendimento presencial."
            );
        }

        Vaga vaga = new Vaga();

        vaga.setInstituicaoId(request.instituicaoId());
        vaga.setAlunoId(request.alunoId());
        vaga.setSupervisorId(request.supervisorId());
        vaga.setDataHora(request.dataHora());
        vaga.setModalidade(request.modalidade());
        vaga.setAbordagemClinica(request.abordagemClinica());
        vaga.setCep(request.cep());
        vaga.setStatus(StatusVaga.DISPONIVEL);

        Vaga salva = vagaRepository.save(vaga);

        return toResponse(salva);
    }

    public List<VagaResponse> listarTodas() {
        return vagaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private VagaResponse toResponse(Vaga vaga) {
        return new VagaResponse(
                vaga.getId(),
                vaga.getInstituicaoId(),
                vaga.getAlunoId(),
                vaga.getSupervisorId(),
                vaga.getDataHora(),
                vaga.getModalidade(),
                vaga.getAbordagemClinica(),
                vaga.getCep(),
                vaga.getStatus()
        );
    }
}