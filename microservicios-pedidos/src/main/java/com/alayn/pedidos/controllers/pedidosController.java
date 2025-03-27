package com.alayn.pedidos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.alayn.commons.controller.CommonController;
import com.alayn.commons.models.entities.Pedido;
import com.alayn.pedidos.dto.PedidoDTO;
import com.alayn.pedidos.services.PedidoService;

@RestController
public class pedidosController extends CommonController<Pedido,PedidoService>{
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Pedido pedido,BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}Pedido pedidoDb=service.actualizar(pedido, id);
		if(pedidoDb != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping("/pedido-dto")
	public ResponseEntity<?> create(@Valid @RequestBody  PedidoDTO pedidoDto, BindingResult result) {
		if(result.hasErrors() ) {
			return this.validar(result);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPedidoDTO(pedidoDto));
	}
}
