package br.com.integrasus.core.service;

import br.com.integrasus.core.dto.PacienteRequest;
import br.com.integrasus.core.dto.PacienteResponse;
import br.com.integrasus.core.entity.Paciente;
import br.com.integrasus.core.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteResponse criar(PacienteRequest request) {

        Paciente paciente = new Paciente();

        paciente.setNomeCompleto(request.nomeCompleto());
        paciente.setCpf(request.cpf());
        paciente.setNumeroCartaoSus(request.numeroCartaoSus());
        paciente.setDataNascimento(request.dataNascimento());
        paciente.setTelefoneCelular(request.telefoneCelular());
        paciente.setEmail(request.email());
        paciente.setAceitaNotificacaoSms(request.aceitaNotificacaoSms());
        paciente.setCep(request.cep());
        paciente.setCidade(request.cidade());
        paciente.setEstado(request.estado());
        paciente.setNecessidadeClinica(request.necessidadeClinica());

        Paciente salvo = pacienteRepository.save(paciente);

        return new PacienteResponse(
                salvo.getId(),
                salvo.getNomeCompleto(),
                salvo.getNumeroCartaoSus(),
                "CADASTRADO"
        );
    }
}