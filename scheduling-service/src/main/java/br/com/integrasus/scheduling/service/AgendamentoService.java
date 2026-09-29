package br.com.integrasus.scheduling.service;

import br.com.integrasus.scheduling.dto.AgendamentoRequest;
import br.com.integrasus.scheduling.dto.AgendamentoResponse;
import br.com.integrasus.scheduling.dto.CancelamentoRequest;
import br.com.integrasus.scheduling.dto.CancelamentoResponse;
import br.com.integrasus.scheduling.entity.Agendamento;
import br.com.integrasus.scheduling.entity.StatusAgendamento;
import br.com.integrasus.scheduling.entity.StatusVaga;
import br.com.integrasus.scheduling.entity.Vaga;
import br.com.integrasus.scheduling.event.VagaEventPublisher;
import br.com.integrasus.scheduling.event.VagaReabertaEvent;
import br.com.integrasus.scheduling.exception.RecursoNaoEncontradoException;
import br.com.integrasus.scheduling.repository.AgendamentoRepository;
import br.com.integrasus.scheduling.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final VagaRepository vagaRepository;
    private final VagaEventPublisher vagaEventPublisher;

    @Transactional
    public AgendamentoResponse criar(AgendamentoRequest request) {

        Vaga vaga = vagaRepository.findById(request.vagaId())
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Vaga não encontrada com id " + request.vagaId()
                        )
                );

        if (vaga.getStatus() != StatusVaga.DISPONIVEL) {
            throw new IllegalArgumentException(
                    "A vaga informada não está disponível."
            );
        }

        Agendamento agendamento = new Agendamento();

        agendamento.setPacienteId(request.pacienteId());
        agendamento.setVaga(vaga);
        agendamento.setStatus(StatusAgendamento.AGENDADO);
        agendamento.setCriadoEm(LocalDateTime.now());

        vaga.setStatus(StatusVaga.OCUPADA);

        vagaRepository.save(vaga);

        Agendamento salvo =
                agendamentoRepository.save(agendamento);

        return new AgendamentoResponse(
                salvo.getId(),
                salvo.getPacienteId(),
                salvo.getVaga().getId(),
                salvo.getVaga().getDataHora(),
                salvo.getStatus()
        );
    }

    @Transactional
    public CancelamentoResponse cancelar(
            Long agendamentoId,
            CancelamentoRequest request
    ) {

        Agendamento agendamento = agendamentoRepository
                .findById(agendamentoId)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Agendamento não encontrado com id " + agendamentoId
                        )
                );

        if (agendamento.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException(
                    "O agendamento já está cancelado."
            );
        }

        Vaga vaga = agendamento.getVaga();

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        vaga.setStatus(StatusVaga.DISPONIVEL);
        agendamento.setMotivoCancelamento(request.motivo());

        agendamentoRepository.save(agendamento);
        vagaRepository.save(vaga);

        VagaReabertaEvent event =
                new VagaReabertaEvent(
                        vaga.getId(),
                        agendamento.getId(),
                        vaga.getDataHora(),
                        vaga.getModalidade().name(),
                        vaga.getAbordagemClinica().name()
                );

        vagaEventPublisher.publicarVagaReaberta(event);

        return new CancelamentoResponse(
                agendamento.getId(),
                agendamento.getStatus(),
                vaga.getId(),
                vaga.getStatus(),
                "Agendamento cancelado e vaga reaberta com sucesso."
        );
    }

    public AgendamentoResponse buscarPorId(Long id) {

        Agendamento agendamento = agendamentoRepository
                .findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Agendamento não encontrado com id " + id
                        )
                );

        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getPacienteId(),
                agendamento.getVaga().getId(),
                agendamento.getVaga().getDataHora(),
                agendamento.getStatus()
        );
    }
}