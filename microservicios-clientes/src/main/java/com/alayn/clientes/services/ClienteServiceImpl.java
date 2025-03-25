package com.alayn.clientes.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alayn.clientes.MicroserviciosClientesApplication;
import com.alayn.clientes.repositories.ClienteRepository;
import com.alayn.commons.models.entities.Cliente;
import com.alayn.commons.services.CommonServiceImpl;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente,ClienteRepository> implements ClienteService {

    private final MicroserviciosClientesApplication microserviciosClientesApplication;

    ClienteServiceImpl(MicroserviciosClientesApplication microserviciosClientesApplication) {
        this.microserviciosClientesApplication = microserviciosClientesApplication;
    }

	@Override
	@Transactional
	public Cliente actualizar(Cliente cliente, Long id) {
		Optional<Cliente> optCliente= repository.findById(id);
		if(optCliente.isPresent()) {
			Cliente clienteDb=optCliente.get();
			clienteDb.setNombre(cliente.getNombre());
			clienteDb.setApellido(cliente.getApellido());
			clienteDb.setEMail(cliente.getEMail());
			clienteDb.setTelefono(cliente.getTelefono());
			clienteDb.setDireccion(cliente.getDireccion());
			repository.save(clienteDb);
			return clienteDb;		
		}
		


		
		
		return null;
	}

	
 
}
