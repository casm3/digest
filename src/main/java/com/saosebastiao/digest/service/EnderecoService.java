package com.saosebastiao.digest.service;

import com.saosebastiao.digest.entity.Endereco;
import com.saosebastiao.digest.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
  @Autowired
  private final EnderecoRepository enderecoRepository;

  public EnderecoService(EnderecoRepository enderecoRepository) {
    this.enderecoRepository = enderecoRepository;
  }

  public Endereco salvarEndereco(Endereco endereco) {
    return enderecoRepository.save(endereco);
  }

  public Optional<Endereco> buscarPorId(Long id) {
    return enderecoRepository.findById(id);
  }

  public void excluirEndereco(Long id) {
    enderecoRepository.deleteById(id);
  }


}
