package com.alayn.clientes.services;

import com.alayn.commons.models.entities.Cliente;
import com.alayn.commons.services.CommonService;

public interface ClienteService  extends CommonService<Cliente> {
	Cliente actualizar(Cliente cliente,Long id);

}
