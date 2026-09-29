package br.com.integrasus.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instituicoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false, unique = true)
    private String cnpj;

    private String telefoneContato;

    private String cep;

    private String cidade;

    private String estado;

    private String logradouro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusInstituicao status;
}