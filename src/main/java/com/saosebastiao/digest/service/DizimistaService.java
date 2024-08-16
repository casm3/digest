package com.saosebastiao.digest.service;

import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.entity.Endereco;
import com.saosebastiao.digest.service.exception.DizimistaNotFoundException;
import com.saosebastiao.digest.repository.DizimistaRepository;
import com.saosebastiao.digest.util.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizimistaService {

  private final DizimistaRepository dizimistaRepository;
  private final EnderecoService enderecoService;

  @Autowired
  public DizimistaService(DizimistaRepository dizimistaRepository, EnderecoService enderecoService) {
    this.dizimistaRepository = dizimistaRepository;
    this.enderecoService = enderecoService;
  }

  public Dizimista salvarDizimista(Dizimista dizimista) {
    Endereco endereco = dizimista.getEndereco();
    if (endereco.getId() == null) {
      endereco = enderecoService.salvarEndereco(endereco);
    }
    dizimista.setEndereco(endereco);
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

  public Dizimista update(Long id, Dizimista dizimista) {
    Dizimista dizimistaDb = buscarPorId(id);
    PropertyMapper.copyNonNullProperties(dizimista, dizimistaDb);
    return dizimistaRepository.save(dizimistaDb);
  }
}
