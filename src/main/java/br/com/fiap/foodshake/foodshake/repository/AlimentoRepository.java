package br.com.fiap.foodshake.foodshake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.foodshake.foodshake.models.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
  
}
