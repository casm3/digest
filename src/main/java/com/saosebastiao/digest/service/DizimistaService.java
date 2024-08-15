package com.saosebastiao.digest.service;

import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.exception.DizimistaNotFoundException;
import com.saosebastiao.digest.repository.DizimistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public Dizimista buscarPorId(Long id) {
    return dizimistaRepository.findById(id).orElseThrow(DizimistaNotFoundException::new);
  }

  public void excluirDizimista(Long id) {
    dizimistaRepository.deleteById(id);
  }

  public List<Dizimista> buscarPorNome(String nome) {
    return dizimistaRepository.findByNomeContaining(nome);
  }

  public Dizimista buscarPorCpf(String cpf) {
    return dizimistaRepository.findByCpf(cpf).orElseThrow(DizimistaNotFoundException::new);
  }
}
