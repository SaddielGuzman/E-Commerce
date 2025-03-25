package com.alayn.clientes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alayn.clientes.services.ClienteService;
import com.alayn.commons.controller.CommonController;
import com.alayn.commons.models.entities.Cliente;

import jakarta.validation.Valid;

@RestController
public class ClienteController extends CommonController<Cliente, ClienteService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente,BindingResult result,@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Cliente clienteDb=service.actualizar(cliente, id);
		if(clienteDb !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
		}
		return ResponseEntity.notFound().build();
	}
	

}
