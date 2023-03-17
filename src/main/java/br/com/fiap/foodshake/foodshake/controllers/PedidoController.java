package br.com.fiap.foodshake.foodshake.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Local;
import br.com.fiap.foodshake.foodshake.models.Manobra;
import br.com.fiap.foodshake.foodshake.models.Pedido;

@RestController
public class PedidoController {
  ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
  Logger log = LoggerFactory.getLogger(PedidoController.class);

  @GetMapping("/api/pedido")
  public ArrayList<Pedido> show() {
    if (pedidos.isEmpty()) {
      Local local = new Local(
          "73060-530",
          "Quadra AR 5 Área Especial 04",
          "Setor Oeste (Sobradinho)",
          "20",
          "8 andar",
          "Brasília",
          "Distrito Federal");

      Manobra m1 = new Manobra("Flip Legal", 1);
      Manobra m2 = new Manobra("Flip Muito Legal", 2);
      Manobra m3 = new Manobra("Flip Meio Legal", 4);
      Manobra[] manobras = { m1, m2, m3 };

      int[] alimentosId = { 1, 3, 10 };

      pedidos.add(new Pedido(
          1,
          1,
          local,
          alimentosId,
          new BigDecimal(12.32),
          manobras));
    }

    return pedidos;
  }

  @GetMapping("/api/pedido/{id}")
  public ResponseEntity<Pedido> show(@PathVariable long id) {
    var pedidoExistente = pedidos
        .stream()
        .filter(a -> a.getId() == id)
        .findFirst();

    if (pedidoExistente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(pedidoExistente.get());
  }

  @PostMapping("/api/pedido")
  public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
    pedido.setId(pedidos.size() + 1l);
    log.info("cadastrando pedido: " + pedido);
    pedidos.add(pedido);

    return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
  }

  @DeleteMapping("/api/pedido/{id}")
  public ResponseEntity<Pedido> delete(@PathVariable long id) {
    var pedidoExistente = pedidos
        .stream()
        .filter(a -> a.getId() == id)
        .findFirst();
    if (pedidoExistente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    pedidos.remove(pedidoExistente.get());
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/api/pedido/{id}")
  public ResponseEntity<Pedido> update(@PathVariable long id, @RequestBody Pedido pedido) {
    var pedidoExistente = pedidos
        .stream()
        .filter(a -> a.getId() == id)
        .findFirst();

    if (pedidoExistente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    pedido.setId(id);
    pedidos.remove(pedidoExistente.get());
    pedidos.add(pedido);

    return ResponseEntity.ok(pedido);
  }
}
