package com.saosebastiao.digest.service;

import com.saosebastiao.digest.entity.Contribuicao;
import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.repository.ContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuicaoService {
  @Autowired
  private final ContribuicaoRepository contribuicaoRepository;

  public ContribuicaoService(ContribuicaoRepository contribuicaoRepository) {
    this.contribuicaoRepository = contribuicaoRepository;
  }

  public Contribuicao salvarContribuicao(Contribuicao contribuicao) {
    return contribuicaoRepository.save(contribuicao);
  }

  public List<Contribuicao> listarContribuicoesDoDizimista(Dizimista dizimista) {
    return contribuicaoRepository.findByDizimista(dizimista);
  }

  public List<Contribuicao> listarTodas() {
    return contribuicaoRepository.findAll();
  }

  public void excluirContribuicao(Long id) {
    contribuicaoRepository.deleteById(id);
  }
}
