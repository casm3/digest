package com.saosebastiao.digest.controller.dto;

import com.saosebastiao.digest.entity.Contribuicao;
import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.entity.Endereco;

public class EntityMapper {
  public static Dizimista toDizimista(DizimistaDto dizimistaDto) {
    Dizimista dizimista = new Dizimista();
    dizimista.setNome(dizimistaDto.nome());
    dizimista.setCpf(dizimistaDto.cpf());
    dizimista.setEmail(dizimistaDto.email());
    dizimista.setDataCadastro(dizimistaDto.dataCadastro());
    dizimista.setDataNascimento(dizimistaDto.dataNascimento());
    dizimista.setEndereco(toEndereco(dizimistaDto.endereco()));
    dizimista.setContribuicoes(dizimistaDto.contribuicoes().stream().map(EntityMapper::toContribuicao).toList());
    return dizimista;
  }

  public static Endereco toEndereco(EnderecoDto enderecoDTO) {
    Endereco endereco = new Endereco();
    endereco.setLogradouro(enderecoDTO.logradouro());
    endereco.setNumero(enderecoDTO.numero());
    endereco.setComplemento(enderecoDTO.complemento());
    endereco.setBairro(enderecoDTO.bairro());
    endereco.setCidade(enderecoDTO.cidade());
    endereco.setEstado(enderecoDTO.estado());
    endereco.setCep(enderecoDTO.cep());
    return endereco;
  }

  public static Contribuicao toContribuicao(ContribuicaoDto contribuicaoDTO) {
    Contribuicao contribuicao = new Contribuicao();
    contribuicao.setValor(contribuicaoDTO.valor());
    contribuicao.setDataContribuicao(contribuicaoDTO.dataContribuicao());
    contribuicao.setMetodoContribuicao(contribuicaoDTO.metodoContribuicao());
    return contribuicao;
  }
}
