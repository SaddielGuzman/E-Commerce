package com.alayn.lista.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alayn.commons.models.entities.ListaProductos;



public interface ListaProductoRepository extends JpaRepository<ListaProductos, Long>{

}
