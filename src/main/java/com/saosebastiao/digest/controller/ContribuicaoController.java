package com.saosebastiao.digest.controller;

import com.saosebastiao.digest.controller.dto.ContribuicaoDto;
import com.saosebastiao.digest.controller.dto.EntityMapper;
import com.saosebastiao.digest.entity.Contribuicao;
import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.service.ContribuicaoService;
import com.saosebastiao.digest.service.DizimistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contribuicoes")
public class ContribuicaoController {
  private final ContribuicaoService contribuicaoService;
  private final DizimistaService dizimistaService;

  @Autowired
  public ContribuicaoController(ContribuicaoService contribuicaoService, DizimistaService dizimistaService) {
    this.contribuicaoService = contribuicaoService;
    this.dizimistaService = dizimistaService;
  }

  @PostMapping("/dizimista/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Contribuicao salvarContribuicao(@PathVariable Long id, @RequestBody ContribuicaoDto contribuicaoDto) {
    Dizimista dizimista = dizimistaService.buscarPorId(id);
    Contribuicao contribuicao = contribuicaoService.salvarContribuicao(EntityMapper.toContribuicao(contribuicaoDto));
    contribuicao.setDizimista(dizimista);
    return contribuicaoService.salvarContribuicao(contribuicao);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Contribuicao buscarPorId(@PathVariable Long id) {
    return contribuicaoService.buscarPorId(id);
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<Contribuicao> listarTodasContribuicoes() {
    return contribuicaoService.listarTodas();
  }

  @GetMapping("/dizimista/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<Contribuicao> listarTodasContribuicoesPorDizimista(@PathVariable Long id) {
    Dizimista dizimista = dizimistaService.buscarPorId(id);
    return contribuicaoService.listarContribuicoesDoDizimista(dizimista);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void excluirContribuicao(@PathVariable Long id) {
    contribuicaoService.excluirContribuicao(id);
  }

  @PatchMapping("/{id}")
  public Contribuicao update(@PathVariable Long id, @RequestBody ContribuicaoDto contribuicaoDto) {
    return contribuicaoService.update(id, EntityMapper.toContribuicao(contribuicaoDto));
  }

}
