package com.felipepc.gatos.exceptions;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BusErrorMensagem implements Serializable {

  private String codigo;
  private String mensagem;
}
