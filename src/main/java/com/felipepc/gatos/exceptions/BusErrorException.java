package com.felipepc.gatos.exceptions;

import com.felipepc.gatos.enums.BusError;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class BusErrorException extends RuntimeException implements Serializable {

  private final BusErrorMensagem busErrorMensagem;

  public BusErrorException(BusError busError) {
    super(busError.getMensagem());
    this.busErrorMensagem = new BusErrorMensagem(busError.getCodigo(), busError.getMensagem());
  }

  public BusErrorException(String codigo, String mensagem) {
    super(mensagem);
    this.busErrorMensagem = new BusErrorMensagem(codigo, mensagem);
  }
}
