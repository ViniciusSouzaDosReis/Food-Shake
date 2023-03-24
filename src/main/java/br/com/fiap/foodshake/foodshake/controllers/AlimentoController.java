package br.com.fiap.foodshake.foodshake.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Alimento;
import br.com.fiap.foodshake.foodshake.repository.AlimentoRepository;

import java.util.List;


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

@RestController
@RequestMapping("/api/alimento")
public class AlimentoController {

  Logger log = LoggerFactory.getLogger(AlimentoController.class);

  @Autowired
  AlimentoRepository repository;

  @GetMapping
  public List<Alimento> index() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public ResponseEntity<Alimento> show(@PathVariable long id) {
    log.info("detalhando alimento: " + id);
    var alimentoEncontrado = repository.findById(id);

    if (alimentoEncontrado.isEmpty())
      return ResponseEntity.notFound().build();

    return ResponseEntity.ok(alimentoEncontrado.get());
  }

  @PostMapping
  public ResponseEntity<Alimento> create(@RequestBody Alimento alimento) {
    log.info("cadastrando alimento " + alimento);
    repository.save(alimento);

    return ResponseEntity.status(HttpStatus.CREATED).body(alimento);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Alimento> destroy(@PathVariable long id) {
    log.info("apagando alimento " + id);
    var alimentoEncontrado = repository.findById(id);

    if (alimentoEncontrado.isEmpty())
      return ResponseEntity.notFound().build();

    repository.delete(alimentoEncontrado.get());

    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<Alimento> update(@PathVariable long id, @RequestBody Alimento alimento) {
    log.info("atualizando alimento " + id);
    var alimentoEncontrado = repository.findById(id);

    if (alimentoEncontrado.isEmpty())
      return ResponseEntity.notFound().build();

    alimento.setId(id);
    repository.save(alimento);

    return ResponseEntity.ok(alimento);
  }
}
