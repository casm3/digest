package com.saosebastiao.digest.service.exception;

public class EnderecoNotFoundException extends CustomNotFoundException {
  public EnderecoNotFoundException() {
    super("Endereço não encontrado!");
  }
}
