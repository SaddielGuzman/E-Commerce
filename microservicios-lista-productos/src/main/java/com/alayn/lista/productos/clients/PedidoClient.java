package com.alayn.lista.productos.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alayn.commons.models.entities.Pedido;

@FeignClient(name="microservicio-pedidos")
public interface PedidoClient {
	
	@GetMapping("/{id}")
	public Optional<Pedido> getPedidoById(@PathVariable Long id);

}
