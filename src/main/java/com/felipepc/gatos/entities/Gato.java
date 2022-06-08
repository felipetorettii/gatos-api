package com.felipepc.gatos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gato")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gato {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "idade")
  private Long idade;

  @Column(name = "cor")
  private String cor;

  @ManyToOne
  @JoinColumn(name = "id_raca")
  private Raca raca;
}
