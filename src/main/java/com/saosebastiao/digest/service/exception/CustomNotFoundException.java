package com.saosebastiao.digest.service.exception;

public class CustomNotFoundException extends RuntimeException {
  public CustomNotFoundException() {
  }

  public CustomNotFoundException(String message) {
    super(message);
  }
}
