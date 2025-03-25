package com.alayn.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alayn.commons.models.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}