package com.alayn.pedidos.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alayn.commons.models.entities.Pedido;
import com.alayn.pedidos.clients.PedidoClient;
import com.alayn.pedidos.dto.PedidoDTO;




@Component
public class PedidoMapper {
	
	@Autowired
	private PedidoClient pedidoclient;
	
	//CONVIERTE UNA ENTIDAD AVION A AVIONDTO
	public PedidoDTO entityToDTO(Pedido pedido) {
		if (pedido == null) {
			return null;
		} 
			PedidoDTO pedidoDTO = new PedidoDTO();
			pedidoDTO.setIdPedido(pedido.getIdPedido());
			pedidoDTO.setIdCliente(pedido.getIdCliente());
			pedidoDTO.setIdListaProductos(pedido.getIdListaProductos());
			pedidoDTO.setTotal(pedido.getTotal());
			pedidoDTO.setFechaCreacion(pedido.getFechaCreacion());
			pedidoDTO.setEstatus(pedido.getEstatus());
		
			return pedidoDTO;
		}
		
	
		public Pedido dtoToEntity(PedidoDTO pedidoDTO) {
			if (pedidoDTO == null) {
				return null;
			} else {
				Pedido pedido = new Pedido();
				pedido.setIdPedido(pedidoDTO.getIdPedido());
				pedido.setIdCliente(pedidoDTO.getIdCliente());
				pedido.setIdListaProductos(pedidoDTO.getIdListaProductos());
				pedido.setTotal(pedidoDTO.getTotal());
				pedido.setFechaCreacion(pedidoDTO.getFechaCreacion());
				pedido.setEstatus(pedidoDTO.getEstatus());
				return pedido;
		}
		}
		
}
