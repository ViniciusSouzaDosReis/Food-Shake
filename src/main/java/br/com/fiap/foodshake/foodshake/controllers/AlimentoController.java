package br.com.fiap.foodshake.foodshake.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodshake.foodshake.models.Alimento;

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

@RestController
public class AlimentoController {
  ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
  Logger log = LoggerFactory.getLogger(AlimentoController.class);

  @GetMapping("/api/alimento")
  public ArrayList<Alimento> show() {
    if (alimentos.isEmpty()) {
      alimentos.add(new Alimento(
          1,
          new BigDecimal(12.32),
          "Cachorro Quente",
          "Cachoror quente Quentinho",
          "FastFood"));
    }
    return alimentos;
  }

  @GetMapping("/api/alimento/{id}")
  public ResponseEntity<Alimento> show(@PathVariable long id) {
    var alimentoExistente = alimentos
        .stream()
        .filter(a -> a.getId() == id)
        .findFirst();

    if (alimentoExistente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(alimentoExistente.get());
  }

  @PostMapping("/api/alimento")
  public ResponseEntity<Alimento> create(@RequestBody Alimento alimento) {
    alimento.setId(alimentos.size() + 1l);
    log.info("cadastrando alimento: " + alimento);
    alimentos.add(alimento);

    return ResponseEntity.status(HttpStatus.CREATED).body(alimento);
  }

  @DeleteMapping("/api/alimento/{id}")
  public ResponseEntity<Alimento> delete(@PathVariable long id) {
    var alimentoExistente = alimentos
        .stream()
        .filter(a -> a.getId() == id)
        .findFirst();
    if (alimentoExistente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    alimentos.remove(alimentoExistente.get());
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/api/alimento/{id}")
  public ResponseEntity<Alimento> update(@PathVariable long id, @RequestBody Alimento alimento) {
    var alimentoExistente = alimentos
        .stream()
        .filter(a -> a.getId() == id)
        .findFirst();

    if (alimentoExistente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    alimento.setId(id);
    alimentos.remove(alimentoExistente.get());
    alimentos.add(alimento);

    return ResponseEntity.ok(alimento);
  }
}
