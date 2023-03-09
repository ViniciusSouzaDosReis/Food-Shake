package br.com.fiap.foodshake.foodshake.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Local;
import br.com.fiap.foodshake.foodshake.models.Manobra;
import br.com.fiap.foodshake.foodshake.models.Pedido;

@RestController
public class PedidoController {

  @GetMapping("/api/pedido")
  public Pedido show(){

    Local local = new Local(
      "73060-530",
      "Quadra AR 5 Área Especial 04",
      "Setor Oeste (Sobradinho)",
      "20",
      "8 andar",
      "Brasília",
      "Distrito Federal"
    );
    
    Manobra m1 = new Manobra("Flip Legal", 1);
    Manobra m2 = new Manobra("Flip Muito Legal", 2);
    Manobra m3 = new Manobra("Flip Meio Legal", 4);
    Manobra[] manobras = {m1,m2,m3};

    int[] alimentosId = {1,3,10};

    return new Pedido(1, 1, local, alimentosId, new BigDecimal(12.32), manobras);
  }
}
