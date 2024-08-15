package com.saosebastiao.digest.controller;

import com.saosebastiao.digest.dto.DizimistaDto;
import com.saosebastiao.digest.dto.EntityMapper;
import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.service.DizimistaService;
import com.saosebastiao.digest.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dizimistas")
public class DizimistaController {
  private final DizimistaService dizimistaService;
  private final EnderecoService enderecoService;

  @Autowired
  public DizimistaController(DizimistaService dizimistaService, EnderecoService enderecoService) {
    this.dizimistaService = dizimistaService;
    this.enderecoService = enderecoService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Dizimista salvarDizimista(@RequestBody DizimistaDto dizimistaDto) {
    return dizimistaService.salvarDizimista(EntityMapper.toDizimista(dizimistaDto));
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Dizimista> listarDizimistas() {
    return dizimistaService.listarDizimistas();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Dizimista buscarPorId(@PathVariable Long id) {
    return dizimistaService.buscarPorId(id);
  }

  @GetMapping("/{cpf}")
  @ResponseStatus(HttpStatus.OK)
  public Dizimista buscarPorCpf(@PathVariable String cpf) {
    return dizimistaService.buscarPorCpf(cpf);
  }

  @GetMapping("/{nome}")
  @ResponseStatus(HttpStatus.OK)
  public List<Dizimista> buscarPorNome(@PathVariable String nome) {
    return dizimistaService.buscarPorNome(nome);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void excluirDizimista(@PathVariable Long id) {
    dizimistaService.excluirDizimista(id);
  }

}
