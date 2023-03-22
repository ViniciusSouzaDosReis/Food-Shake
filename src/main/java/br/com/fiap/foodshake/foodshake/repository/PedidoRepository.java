package br.com.fiap.foodshake.foodshake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.foodshake.foodshake.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
  
}
