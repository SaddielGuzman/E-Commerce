package com.alayn.pedidos.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alayn.commons.models.entities.Cliente;


@FeignClient(name="microservicios-clientes")
public interface ClienteClient {
	@GetMapping("/{id}")
	public Optional<Cliente> getAerolineaById(@PathVariable Long id);

}
