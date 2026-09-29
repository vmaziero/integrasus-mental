package br.com.integrasus.scheduling.repository;

import br.com.integrasus.scheduling.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository
        extends JpaRepository<Vaga, Long> {
}