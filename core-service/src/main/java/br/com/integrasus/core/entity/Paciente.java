package br.com.integrasus.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String numeroCartaoSus;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private String telefoneCelular;

    private String email;

    private Boolean aceitaNotificacaoSms;

    private String cep;

    private String cidade;

    private String estado;

    private String necessidadeClinica;
}