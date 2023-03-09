package br.com.fiap.foodshake.foodshake.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Local;
import br.com.fiap.foodshake.foodshake.models.Usuario;

@RestController
public class UsuarioController {
  @GetMapping("/api/usuario")
  public Usuario show(){
    Local local = new Local(
      "73060-530",
      "Quadra AR 5 Área Especial 04",
      "Setor Oeste (Sobradinho)",
      "20",
      "8 andar",
      "Brasília",
      "Distrito Federal"
    );

    return new Usuario(
      1,
      "Felipe",
      "DaSilva",
      LocalDate.now(), 
      "714.713.648-95", 
      "cleiton",
      "(11)95043-3454",
      "senhadificil123",
      local);
  }
}
