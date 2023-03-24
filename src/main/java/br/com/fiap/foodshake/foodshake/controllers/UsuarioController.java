package br.com.fiap.foodshake.foodshake.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import br.com.fiap.foodshake.foodshake.models.Usuario;
import br.com.fiap.foodshake.foodshake.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

  Logger log = LoggerFactory.getLogger(UsuarioController.class);

  @Autowired
  UsuarioRepository repository;

  @GetMapping
  public List<Usuario> index() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public ResponseEntity<Usuario> show(@PathVariable long id){
    log.info("detalhando usuario: " + id);
    var usuarioEncontrado = repository.findById(id);

    if (usuarioEncontrado.isEmpty()) return ResponseEntity.notFound().build();

    return ResponseEntity.ok(usuarioEncontrado.get());
  }

  @PostMapping
  public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
    log.info("cadastrando usuairo: " + usuario);
    repository.save(usuario);

    return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
  }
  
  @DeleteMapping("{id}")
  public ResponseEntity<Usuario> destroy(@PathVariable long id){
    log.info("apagando usuario: " + id);
    var usuarioEncontrado = repository.findById(id);

    if (usuarioEncontrado.isEmpty()) return ResponseEntity.notFound().build();

    repository.delete(usuarioEncontrado.get());

    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<Usuario> update(@PathVariable long id, @RequestBody Usuario usuario){
    log.info("autalizando usuario: " + id);
    var usuarioEncontrado = repository.findById(id);

    if (usuarioEncontrado.isEmpty()) return ResponseEntity.notFound().build();

    usuario.setId(id);
    repository.save(usuario);

    return ResponseEntity.ok(usuario);

  }
}
