package br.com.integrasus.core.repository;

import br.com.integrasus.core.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository
        extends JpaRepository<Paciente, Long> {
}