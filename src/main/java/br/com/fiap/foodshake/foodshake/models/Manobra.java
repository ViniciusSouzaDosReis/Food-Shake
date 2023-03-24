package br.com.fiap.foodshake.foodshake.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Manobra")
public class Manobra {
  private String nome;
  private int quantidade;

  public Manobra(String nome, int quantidade) {
    this.nome = nome;
    this.quantidade = quantidade;
  }

  protected Manobra(){
    
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

}
