package br.com.fiap.foodshake.foodshake.controllers;

import java.time.LocalDate;
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
import br.com.fiap.foodshake.foodshake.models.Usuario;

@RestController
public class UsuarioController {
  ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
  Logger log = LoggerFactory.getLogger(UsuarioController.class);

  @GetMapping("/api/usuario")
  public ArrayList<Usuario> show() {
    if (usuarios.isEmpty()) {
      Local local = new Local(
          "73060-530",
          "Quadra AR 5 Área Especial 04",
          "Setor Oeste (Sobradinho)",
          "20",
          "8 andar",
          "Brasília",
          "Distrito Federal");

      usuarios.add(new Usuario(
          1,
          "Felipes",
          "DaSilva",
          LocalDate.now(),
          "714.713.648-95",
          "cleiton",
          "(11)95043-3454",
          "senhadificil123",
          local));
    }

    return usuarios;
  }

  @GetMapping("/api/usuario/{id}")
  public ResponseEntity<Usuario> show(@PathVariable long id){
    var usuarioExistente = usuarios
      .stream()
      .filter(u -> u.getId() == id)
      .findFirst();
    
    if(usuarioExistente.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(usuarioExistente.get());
  }

  @PostMapping("/api/usuario")
  public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
    usuario.setId(usuarios.size() + 1l);
    log.info("cadastrando alimento: " + usuario);
    usuarios.add(usuario);

    return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
  }
  
  @DeleteMapping("/api/usuario/{id}")
  public ResponseEntity<Usuario> delete(@PathVariable long id){
    var usuarioExistente = usuarios
      .stream()
      .filter(u -> u.getId() == id)
      .findFirst();

   if(usuarioExistente.isEmpty()){
      return ResponseEntity.notFound().build();
    }

    usuarios.remove(usuarioExistente.get());
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/api/usuario/{id}")
  public ResponseEntity<Usuario> update(@PathVariable long id, @RequestBody Usuario usuario){
    var usuarioExistente = usuarios
      .stream()
      .filter(u -> u.getId() == id)
      .findFirst();
    
    if(usuarioExistente.isEmpty()){
      return ResponseEntity.notFound().build();
    }

    usuario.setId(id);
    usuarios.remove(usuarioExistente.get());
    usuarios.add(usuario);

    return ResponseEntity.ok(usuario);
  }
}
