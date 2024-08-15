package com.saosebastiao.digest.controller;

import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.service.DizimistaService;
import com.saosebastiao.digest.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
  public Dizimista salvarDizimista(@RequestBody Dizimista dizimista) {
    return dizimistaService.salvarDizimista(dizimista);
  }

}
