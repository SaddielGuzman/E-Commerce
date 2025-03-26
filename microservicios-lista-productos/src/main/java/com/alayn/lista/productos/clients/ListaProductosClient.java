package com.alayn.lista.productos.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alayn.commons.models.entities.ListaProductos;

@FeignClient(name="microservicio-pedidos")
public interface ListaProductosClient {
	
	@GetMapping("/{id}")
	public Optional<ListaProductos> getPedidoById(@PathVariable Long id);

}
