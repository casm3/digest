package com.saosebastiao.digest.service;

import com.saosebastiao.digest.controller.dto.ContribuicaoDto;
import com.saosebastiao.digest.entity.Contribuicao;
import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.repository.ContribuicaoRepository;
import com.saosebastiao.digest.service.exception.ContribuicaoNotFoundException;
import com.saosebastiao.digest.util.PropertyMapper;
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

  public Contribuicao buscarPorId(Long id) {
    return contribuicaoRepository.findById(id).orElseThrow(ContribuicaoNotFoundException::new);
  }

  public void excluirContribuicao(Long id) {
    contribuicaoRepository.deleteById(id);
  }

  public Contribuicao update(Long id, Contribuicao contribuicao) {
    Contribuicao contribuicaoDb = buscarPorId(id);
    PropertyMapper.copyNonNullProperties(contribuicao, contribuicaoDb);
    return contribuicaoRepository.save(contribuicaoDb);
  }
}
