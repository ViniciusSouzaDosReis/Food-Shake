package br.com.fiap.foodshake.foodshake.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Alimento;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AlimentoController {

  @GetMapping("/api/alimento")
  public Alimento show() {
    return new Alimento(
      100,
      new BigDecimal(12.32),
      "Cachorro Quente",
      "Cachoror quente Quentinho",
      "FastFood");
  }

}
