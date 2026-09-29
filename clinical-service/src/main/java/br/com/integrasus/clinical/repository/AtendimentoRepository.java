package br.com.integrasus.clinical.repository;

import br.com.integrasus.clinical.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository
        extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findByPacienteId(Long pacienteId);
}