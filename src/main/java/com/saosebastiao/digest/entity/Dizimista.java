package com.saosebastiao.digest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dizimista {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String cpf;

  @ManyToOne
  @JoinColumn(name = "endereco_id")
  private Endereco endereco;

  private String telefone;
  private String email;
  private LocalDate dataNascimento;
  private LocalDate dataCadastro;

  @OneToMany(mappedBy = "dizimista", cascade = CascadeType.ALL)
  private List<Contribuicao> contribuicoes;
}
