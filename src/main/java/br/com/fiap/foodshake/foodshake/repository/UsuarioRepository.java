package br.com.fiap.foodshake.foodshake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.foodshake.foodshake.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  
}
