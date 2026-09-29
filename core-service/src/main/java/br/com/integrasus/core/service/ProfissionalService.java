package br.com.integrasus.core.service;

import br.com.integrasus.core.dto.ProfissionalRequest;
import br.com.integrasus.core.dto.ProfissionalResponse;
import br.com.integrasus.core.entity.Instituicao;
import br.com.integrasus.core.entity.PerfilProfissional;
import br.com.integrasus.core.entity.Profissional;
import br.com.integrasus.core.exception.RecursoNaoEncontradoException;
import br.com.integrasus.core.repository.InstituicaoRepository;
import br.com.integrasus.core.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;
    private final InstituicaoRepository instituicaoRepository;

    public ProfissionalResponse criar(ProfissionalRequest request) {

        Instituicao instituicao = instituicaoRepository
                .findById(request.instituicaoId())
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Instituição não encontrada com id "
                                        + request.instituicaoId()
                        )
                );

        Profissional supervisor = null;

        if (request.perfil() == PerfilProfissional.ALUNO) {

            if (request.supervisorId() == null) {
                throw new IllegalArgumentException(
                        "Aluno deve possuir um supervisor."
                );
            }

            supervisor = profissionalRepository
                    .findById(request.supervisorId())
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException(
                                    "Supervisor não encontrado com id "
                                            + request.supervisorId()
                            )
                    );

            if (supervisor.getPerfil() != PerfilProfissional.SUPERVISOR) {
                throw new IllegalArgumentException(
                        "O profissional informado não possui perfil SUPERVISOR."
                );
            }
        }

        Profissional profissional = new Profissional();

        profissional.setNome(request.nome());
        profissional.setCpf(request.cpf());
        profissional.setEmail(request.email());
        profissional.setPerfil(request.perfil());
        profissional.setInstituicao(instituicao);
        profissional.setMatricula(request.matricula());
        profissional.setSemestre(request.semestre());
        profissional.setSupervisor(supervisor);

        Profissional salvo =
                profissionalRepository.save(profissional);

        return new ProfissionalResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getPerfil(),
                salvo.getInstituicao().getId(),
                salvo.getSupervisor() != null
                        ? salvo.getSupervisor().getId()
                        : null
        );
    }
}