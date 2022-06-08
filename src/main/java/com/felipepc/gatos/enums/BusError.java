package com.felipepc.gatos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusError {

  E001("001", "Raça não encontrada!"),
  E002("002", "Gato não encontrado!"),
  E003("003", "Raça já está em uso, logo não pode ser deletada!"),
  E004("004", "A raça '%s' já existe com código '%d'!"),

  E999("999", "Não foi possível identificar o erro, contacte o adminstrador do sistema!");

  private final String codigo;
  private final String mensagem;

  public String formatarMensagem(Object... itens) {
    try {
      return String.format(this.mensagem, itens);
    } catch (Exception e) {
      return E999.getMensagem();
    }
  }
}
