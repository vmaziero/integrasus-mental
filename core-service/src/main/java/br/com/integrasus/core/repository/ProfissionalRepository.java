package br.com.integrasus.core.repository;

import br.com.integrasus.core.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository
        extends JpaRepository<Profissional, Long> {
}