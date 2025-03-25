package com.alayn.pedidos.services;

import com.alayn.commons.models.entities.Pedido;
import com.alayn.commons.services.CommonService;
import com.alayn.pedidos.dto.PedidoDTO;

public interface PedidoService extends CommonService<Pedido>{
	
	Pedido createPedidoDTO(PedidoDTO pedidoDTO);
	
	Pedido update(PedidoDTO pedidoDTO, Long id);

}
