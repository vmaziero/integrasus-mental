package br.com.integrasus.clinical.service;

import br.com.integrasus.clinical.dto.*;
import br.com.integrasus.clinical.entity.AnotacaoClinica;
import br.com.integrasus.clinical.entity.Atendimento;
import br.com.integrasus.clinical.entity.StatusAtendimento;
import br.com.integrasus.clinical.repository.AnotacaoClinicaRepository;
import br.com.integrasus.clinical.repository.AtendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final AnotacaoClinicaRepository anotacaoClinicaRepository;

    public AtendimentoResponse criar(AtendimentoRequest request) {

        Atendimento atendimento = new Atendimento();

        atendimento.setAgendamentoId(request.agendamentoId());
        atendimento.setPacienteId(request.pacienteId());
        atendimento.setAlunoId(request.alunoId());
        atendimento.setSupervisorId(request.supervisorId());
        atendimento.setStatus(StatusAtendimento.EM_ATENDIMENTO);
        atendimento.setCriadoEm(LocalDateTime.now());

        Atendimento salvo = atendimentoRepository.save(atendimento);

        return new AtendimentoResponse(
                salvo.getId(),
                salvo.getAgendamentoId(),
                salvo.getPacienteId(),
                salvo.getStatus()
        );
    }

    @Transactional
    public AnotacaoClinicaResponse registrarAnotacao(
            Long atendimentoId,
            AnotacaoClinicaRequest request
    ) {

        Atendimento atendimento = atendimentoRepository
                .findById(atendimentoId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Atendimento não encontrado com id " + atendimentoId
                        )
                );

        if (atendimento.getStatus() == StatusAtendimento.CONCLUIDO) {
            throw new IllegalArgumentException(
                    "Não é possível alterar um atendimento concluído."
            );
        }

        if (anotacaoClinicaRepository
                .findByAtendimentoId(atendimentoId)
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Já existe uma anotação clínica para este atendimento."
            );
        }

        AnotacaoClinica anotacao = new AnotacaoClinica();

        anotacao.setAtendimento(atendimento);
        anotacao.setQueixaPrincipal(request.queixaPrincipal());
        anotacao.setEvolucao(request.evolucao());
        anotacao.setHipoteseDiagnostica(request.hipoteseDiagnostica());
        anotacao.setNivelRisco(request.nivelRisco());
        anotacao.setAprovado(false);

        atendimento.setStatus(
                StatusAtendimento.AGUARDANDO_SUPERVISAO
        );

        AnotacaoClinica salva =
                anotacaoClinicaRepository.save(anotacao);

        atendimentoRepository.save(atendimento);

        return new AnotacaoClinicaResponse(
                salva.getId(),
                atendimento.getId(),
                atendimento.getStatus(),
                "Anotação clínica registrada e enviada para supervisão."
        );
    }

    @Transactional
    public AprovacaoAnotacaoResponse aprovarAnotacao(
            Long atendimentoId,
            AprovacaoAnotacaoRequest request
    ) {

        Atendimento atendimento = atendimentoRepository
                .findById(atendimentoId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Atendimento não encontrado com id " + atendimentoId
                        )
                );

        if (atendimento.getStatus() != StatusAtendimento.AGUARDANDO_SUPERVISAO) {
            throw new IllegalArgumentException(
                    "O atendimento não está aguardando supervisão."
            );
        }

        AnotacaoClinica anotacao = anotacaoClinicaRepository
                .findByAtendimentoId(atendimentoId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Nenhuma anotação clínica encontrada para este atendimento."
                        )
                );

        anotacao.setAprovado(request.aprovado());
        anotacao.setParecerSupervisor(request.parecerSupervisor());
        anotacao.setAprovadoEm(LocalDateTime.now());

        if (Boolean.TRUE.equals(request.aprovado())) {
            atendimento.setStatus(StatusAtendimento.CONCLUIDO);
        }

        anotacaoClinicaRepository.save(anotacao);
        atendimentoRepository.save(atendimento);

        return new AprovacaoAnotacaoResponse(
                anotacao.getId(),
                atendimento.getId(),
                anotacao.getAprovado(),
                atendimento.getStatus(),
                Boolean.TRUE.equals(request.aprovado())
                        ? "Anotação aprovada e atendimento concluído."
                        : "Anotação revisada pelo supervisor."
        );
    }

    public List<HistoricoAtendimentoResponse> buscarHistoricoPaciente(
            Long pacienteId
    ) {

        List<Atendimento> atendimentos =
                atendimentoRepository.findByPacienteId(pacienteId);

        return atendimentos.stream()
                .map(atendimento -> {

                    AnotacaoClinica anotacao =
                            anotacaoClinicaRepository
                                    .findByAtendimentoId(atendimento.getId())
                                    .orElse(null);

                    return new HistoricoAtendimentoResponse(
                            atendimento.getId(),
                            atendimento.getAgendamentoId(),
                            atendimento.getAlunoId(),
                            atendimento.getSupervisorId(),
                            atendimento.getStatus(),
                            atendimento.getCriadoEm(),

                            anotacao != null
                                    ? anotacao.getQueixaPrincipal()
                                    : null,

                            anotacao != null
                                    ? anotacao.getEvolucao()
                                    : null,

                            anotacao != null
                                    ? anotacao.getHipoteseDiagnostica()
                                    : null,

                            anotacao != null
                                    ? anotacao.getNivelRisco()
                                    : null,

                            anotacao != null
                                    ? anotacao.getAprovado()
                                    : null,

                            anotacao != null
                                    ? anotacao.getParecerSupervisor()
                                    : null
                    );
                })
                .toList();
    }
}