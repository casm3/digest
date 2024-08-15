package com.saosebastiao.digest.service;

import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.repository.DizimistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DizimistaService {

  @Autowired
  private final DizimistaRepository dizimistaRepository;

  public DizimistaService(DizimistaRepository dizimistaRepository) {
    this.dizimistaRepository = dizimistaRepository;
  }

  public Dizimista salvarDizimista(Dizimista dizimista) {
    return dizimistaRepository.save(dizimista);
  }

  public List<Dizimista> listarDizimistas() {
    return dizimistaRepository.findAll();
  }

  public Optional<Dizimista> buscarPorId(Long id) {
    return dizimistaRepository.findById(id);
  }

  public void excluirDizimista(Long id) {
    dizimistaRepository.deleteById(id);
  }

  public List<Dizimista> buscarPorNome(String nome) {
    return dizimistaRepository.findByNomeContaining(nome);
  }

  public Optional<Dizimista> buscarPorCpf(String cpf) {
    return dizimistaRepository.findByCpf(cpf);
  }
}
