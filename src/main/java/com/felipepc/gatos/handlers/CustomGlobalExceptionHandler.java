package com.felipepc.gatos.handlers;

import com.felipepc.gatos.exceptions.BusErrorException;
import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler implements
    Serializable {

  @ExceptionHandler(value
      = {BusErrorException.class})
  protected ResponseEntity<Object> handleConflict(
      BusErrorException ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getBusErrorMensagem());
  }
}
