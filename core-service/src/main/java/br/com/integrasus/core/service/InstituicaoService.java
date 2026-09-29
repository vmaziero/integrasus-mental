package br.com.integrasus.core.service;

import br.com.integrasus.core.dto.InstituicaoRequest;
import br.com.integrasus.core.dto.InstituicaoResponse;
import br.com.integrasus.core.entity.Instituicao;
import br.com.integrasus.core.entity.StatusInstituicao;
import br.com.integrasus.core.exception.RecursoNaoEncontradoException;
import br.com.integrasus.core.repository.InstituicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoResponse criar(InstituicaoRequest request) {

        Instituicao instituicao = new Instituicao();

        instituicao.setRazaoSocial(request.razaoSocial());
        instituicao.setNomeFantasia(request.nomeFantasia());
        instituicao.setCnpj(request.cnpj());
        instituicao.setTelefoneContato(request.telefoneContato());
        instituicao.setCep(request.cep());
        instituicao.setCidade(request.cidade());
        instituicao.setEstado(request.estado());
        instituicao.setLogradouro(request.logradouro());
        instituicao.setStatus(StatusInstituicao.ATIVA);

        Instituicao instituicaoSalva =
                instituicaoRepository.save(instituicao);

        return new InstituicaoResponse(
                instituicaoSalva.getId(),
                instituicaoSalva.getNomeFantasia(),
                instituicaoSalva.getStatus(),
                "Instituição cadastrada com sucesso."
        );
    }

    public InstituicaoResponse buscarPorId(Long id) {

        Instituicao instituicao = instituicaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Instituição não encontrada com id " + id));

        return new InstituicaoResponse(
                instituicao.getId(),
                instituicao.getNomeFantasia(),
                instituicao.getStatus(),
                "Instituição encontrada com sucesso."
        );
    }

    public List<InstituicaoResponse> listarTodas() {
        return instituicaoRepository.findAll()
                .stream()
                .map(instituicao -> new InstituicaoResponse(
                        instituicao.getId(),
                        instituicao.getNomeFantasia(),
                        instituicao.getStatus(),
                        null
                ))
                .toList();
    }

}
