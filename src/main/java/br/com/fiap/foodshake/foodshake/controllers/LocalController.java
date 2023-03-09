package br.com.fiap.foodshake.foodshake.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Local;

@RestController
public class LocalController {
  @GetMapping("/api/local")
  public Local show(){
    return new Local(
      "73060-530",
      "Quadra AR 5 Área Especial 04",
      "Setor Oeste (Sobradinho)",
      "20",
      "8 andar",
      "Brasília",
      "Distrito Federal");
  }

}
