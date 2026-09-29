package br.com.integrasus.scheduling.repository;

import br.com.integrasus.scheduling.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository
        extends JpaRepository<Agendamento, Long> {
}