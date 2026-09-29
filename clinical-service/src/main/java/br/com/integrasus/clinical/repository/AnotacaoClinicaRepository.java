package br.com.integrasus.clinical.repository;

import br.com.integrasus.clinical.entity.AnotacaoClinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnotacaoClinicaRepository
        extends JpaRepository<AnotacaoClinica, Long> {

    Optional<AnotacaoClinica> findByAtendimentoId(Long atendimentoId);
}