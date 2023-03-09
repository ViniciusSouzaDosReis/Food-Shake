package br.com.fiap.foodshake.foodshake.models;

import java.math.BigDecimal;

public class Pedido {
  private long id;
  private long idUsuario;
  private Local localEntrega;
  private int  alimentos[];
  private BigDecimal valor;
  private Manobra manobras[];
  private boolean entregue;
  private boolean finalizado;
  
  public Pedido(long id, long idUsuario, Local localEntrega, int[] alimentos, BigDecimal valor,
      Manobra[] manobras) {
    this.id = id;
    this.idUsuario = idUsuario;
    this.localEntrega = localEntrega;
    this.alimentos = alimentos;
    this.valor = valor;
    this.manobras = manobras;
  }
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public long getIdUsuario() {
    return idUsuario;
  }
  public void setIdUsuario(long idUsuario) {
    this.idUsuario = idUsuario;
  }
  public Local getLocalEntrega() {
    return localEntrega;
  }
  public void setLocalEntrega(Local localEntrega) {
    this.localEntrega = localEntrega;
  }
  public int[] getAlimentos() {
    return alimentos;
  }
  public void setAlimentos(int[] alimentos) {
    this.alimentos = alimentos;
  }
  public BigDecimal getValor() {
    return valor;
  }
  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
  public Manobra[] getManobras() {
    return manobras;
  }
  public void setManobras(Manobra[] manobras) {
    this.manobras = manobras;
  }
  public boolean isEntregue() {
    return entregue;
  }
  public void setEntregue(boolean entregue) {
    this.entregue = entregue;
  }
  public boolean isFinalizado() {
    return finalizado;
  }
  public void setFinalizado(boolean finalizado) {
    this.finalizado = finalizado;
  }

  

}
