package br.com.integrasus.core.repository;

import br.com.integrasus.core.entity.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository
        extends JpaRepository<Instituicao, Long> {
}