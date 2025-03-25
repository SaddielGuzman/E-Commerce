package com.alayn.productos.services;

import com.alayn.commons.models.entities.Producto;
import com.alayn.commons.services.CommonService;

public interface ProductoService extends CommonService<Producto>{

	Producto actualizar(Producto producto, Long i);
}
