package com.alayn.lista.productos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alayn.commons.controller.CommonController;
import com.alayn.commons.models.entities.ListaProductos;
import com.alayn.lista.productos.dto.ListaProductoDTO;
import com.alayn.lista.productos.services.ListaProductosService;

import jakarta.validation.Valid;

@RestController
public class ListaProductosController extends CommonController<ListaProductos, ListaProductosService> {

    @PostMapping("/producto-dto")
    public ResponseEntity<?> create(@Valid @RequestBody ListaProductoDTO listaProductosDto, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createListaProductoDTO(listaProductosDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ListaProductoDTO listaProductoDTO, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        ListaProductos listaProductos = service.update(listaProductoDTO, id);
        if (listaProductos != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(listaProductos);
        }
        return ResponseEntity.notFound().build();
    }
}
