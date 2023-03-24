package br.com.fiap.foodshake.foodshake.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Local;
import br.com.fiap.foodshake.foodshake.models.Manobra;
import br.com.fiap.foodshake.foodshake.models.Pedido;
import br.com.fiap.foodshake.foodshake.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

  Logger log = LoggerFactory.getLogger(PedidoController.class);

  @Autowired
  PedidoRepository repository;

  @GetMapping
  public List<Pedido> index() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public ResponseEntity<Pedido> show(@PathVariable long id) {
    log.info("detalhando pedido: " + id);
    var pedidoEncontrado = repository.findById(id);

    if (pedidoEncontrado.isEmpty())
      return ResponseEntity.notFound().build();
    
    return ResponseEntity.ok(pedidoEncontrado.get());
  }

  @PostMapping
  public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
    log.info("Cadastrando pedido: " + pedido);
    repository.save(pedido);

    return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Pedido> destroy(@PathVariable long id) {
    log.info("apagando pedido: " + id);
    var pedidoEncontrado = repository.findById(id);

    if (pedidoEncontrado.isEmpty())
      return ResponseEntity.notFound().build();
    
    repository.delete(pedidoEncontrado.get());

    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<Pedido> update(@PathVariable long id, @RequestBody Pedido pedido) {
    log.info("atualizando pedido: " + id);
    var pedidoEncontrado = repository.findById(id);

    if (pedidoEncontrado.isEmpty())
      return ResponseEntity.notFound().build();
    
    pedido.setId(id);
    repository.save(pedido);

    return ResponseEntity.ok(pedido);
  }
}
