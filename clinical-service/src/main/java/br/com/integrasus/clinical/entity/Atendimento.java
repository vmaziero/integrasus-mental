package br.com.integrasus.clinical.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long agendamentoId;

    @Column(nullable = false)
    private Long pacienteId;

    @Column(nullable = false)
    private Long alunoId;

    @Column(nullable = false)
    private Long supervisorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAtendimento status;

    @Column(nullable = false)
    private LocalDateTime criadoEm;
}