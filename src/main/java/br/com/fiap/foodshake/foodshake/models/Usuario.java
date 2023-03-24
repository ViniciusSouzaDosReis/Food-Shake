package br.com.fiap.foodshake.foodshake.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pedido")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private String sobreNome;
  private LocalDate dataNascimento;
  private String cpf;
  private String email;
  private String telefone;
  private String senha;
  private Local localizacao;

  protected Usuario() {

  }

  public Usuario(long id, String nome, String sobreNome, LocalDate dataNascimento, String cpf, String email,
      String telefone, String senha) {
    this.id = id;
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.email = email;
    this.telefone = telefone;
    this.senha = senha;
  }

  public Usuario(long id, String nome, String sobreNome, LocalDate dataNascimento, String cpf, String email,
      String telefone, String senha, Local localizacao) {
    this.id = id;
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.email = email;
    this.telefone = telefone;
    this.senha = senha;
    this.localizacao = localizacao;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobreNome() {
    return sobreNome;
  }

  public void setSobreNome(String sobreNome) {
    this.sobreNome = sobreNome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Local getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(Local localizacao) {
    this.localizacao = localizacao;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", dataNascimento=" + dataNascimento
        + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", senha=" + senha + ", localizacao="
        + localizacao + "]";
  }
}
