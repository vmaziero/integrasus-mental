package br.com.integrasus.clinical.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "anotacoes_clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnotacaoClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "atendimento_id", nullable = false, unique = true)
    private Atendimento atendimento;

    @Column(nullable = false, length = 1000)
    private String queixaPrincipal;

    @Column(nullable = false, length = 4000)
    private String evolucao;

    @Column(length = 1000)
    private String hipoteseDiagnostica;

    private String nivelRisco;

    @Column(length = 2000)
    private String parecerSupervisor;

    private Boolean aprovado;

    private LocalDateTime aprovadoEm;
}