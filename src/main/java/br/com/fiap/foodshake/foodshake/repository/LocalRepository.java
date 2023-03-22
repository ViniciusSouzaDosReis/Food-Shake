package br.com.fiap.foodshake.foodshake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.foodshake.foodshake.models.Local;

public interface LocalRepository extends JpaRepository<Local, Long>{
  
}
