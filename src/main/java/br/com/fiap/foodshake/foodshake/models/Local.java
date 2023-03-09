package br.com.fiap.foodshake.foodshake.models;

public class Local {
  private String cep;
  private String endereco;
  private String bairro;
  private String numero;
  private String complemento;
  private String cidade;
  private String estado;

  public Local(String cep, String endereco, String bairro, String numero, String complemento, String cidade,
      String estado) {
    this.cep = cep;
    this.endereco = endereco;
    this.bairro = bairro;
    this.numero = numero;
    this.complemento = complemento;
    this.cidade = cidade;
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Local [cep=" + cep + ", endereco=" + endereco + ", bairro=" + bairro + ", numero=" + numero
        + ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + "]";
  }
}
