package com.alayn.pedidos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alayn.commons.models.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
