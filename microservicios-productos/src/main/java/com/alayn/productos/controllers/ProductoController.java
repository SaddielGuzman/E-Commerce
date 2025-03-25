package com.alayn.productos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alayn.commons.controller.CommonController;
import com.alayn.commons.models.entities.Producto;
import com.alayn.productos.services.ProductoService;

import jakarta.validation.Valid;




@RestController
public class ProductoController extends CommonController<Producto, ProductoService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Producto producto,
			BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Producto productoDb = service.actualizar(producto, id);
		if(productoDb != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(productoDb);
		}
		return ResponseEntity.notFound().build();
		
	}

}
