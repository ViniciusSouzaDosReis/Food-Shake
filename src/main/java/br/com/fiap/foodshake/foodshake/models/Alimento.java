package br.com.fiap.foodshake.foodshake.models;

import java.math.BigDecimal;

public class Alimento {
  private long id;
  private BigDecimal valor;
  private String nome;
  private String descricao;
  private String categoria;

  public Alimento(long id, BigDecimal valor, String nome, String descricao, String categoria) {
    this.id = id;
    this.valor = valor;
    this.nome = nome;
    this.descricao = descricao;
    this.categoria = categoria;
  }

  public Alimento() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return "Alimento [id=" + id + ", valor=" + valor + ", nome=" + nome + ", descricao=" + descricao + ", categoria="
        + categoria + "]";
  }

}
