package com.alayn.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alayn.commons.models.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
 
}
