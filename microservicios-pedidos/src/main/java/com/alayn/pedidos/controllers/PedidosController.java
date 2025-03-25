package com.alayn.pedidos.controllers;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alayn.commons.controller.CommonController;
import com.alayn.commons.models.entities.Pedido;
import com.alayn.pedidos.dto.PedidoDTO;
import com.alayn.pedidos.services.PedidoService;

import jakarta.validation.Valid;

@RestController
public class PedidosController extends CommonController<Pedido, PedidoService>{
	
	
	@PostMapping("/pedido-dto")
	public ResponseEntity<?> create(@Valid @RequestBody PedidoDTO pedidoDto, BindingResult result){

	if(result.hasErrors()) {
		return this.validar(result);
	}
	return ResponseEntity.status(HttpStatus.CREATED).body(service.createPedidoDTO(pedidoDto));
}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody  PedidoDTO pedidoDTO,
			BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Pedido pedido = service.update(pedidoDTO, id);
		if(pedidoDTO != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
		}
		return ResponseEntity.notFound().build();
		
	}
}
