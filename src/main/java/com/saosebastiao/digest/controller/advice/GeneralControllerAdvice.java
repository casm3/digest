package com.saosebastiao.digest.controller.advice;

import com.saosebastiao.digest.service.exception.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {
  @ExceptionHandler(CustomNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFound(CustomNotFoundException e) {
    return e.getMessage();
  }
}
