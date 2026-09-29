package br.com.integrasus.scheduling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vagas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long instituicaoId;

    @Column(nullable = false)
    private Long alunoId;

    @Column(nullable = false)
    private Long supervisorId;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModalidadeAtendimento modalidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AbordagemClinica abordagemClinica;

    private String cep;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVaga status;
}