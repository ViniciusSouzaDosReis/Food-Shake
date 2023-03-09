package br.com.fiap.foodshake.foodshake.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Manobra;

@RestController
public class ManobraController {
  
  @GetMapping("/api/manobra")
  public Manobra show(){
    return new Manobra("Flip", 3);
  }
}
