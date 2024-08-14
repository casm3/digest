package com.saosebastiao.digest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cidade;
  private String estado;
  private String cep;

  @OneToMany
  private List<Dizimista> dizimistas;
}
