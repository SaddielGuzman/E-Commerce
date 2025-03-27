package com.alayn.pedidos.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alayn.commons.models.entities.Cliente;
import com.alayn.commons.models.entities.Pedido;
import com.alayn.pedidos.clients.ClienteClient;
import com.alayn.pedidos.dto.PedidoDTO;


@Component
public class PedidoMapper {
	
	@Autowired
	private ClienteClient clienteClient;
	
	public PedidoDTO entityToDto(Pedido pedido){
		if(pedido==null){
			return null;
		}
		
		PedidoDTO pedidoDto= new PedidoDTO();
		pedidoDto.setId(pedido.getId());
		
	
		pedidoDto.setCliente(pedido.getCliente());
		pedidoDto.setProductos(pedido.getProductos());
		pedidoDto.setTotal(pedido.getTotal());
		pedidoDto.setFechaCreacion(pedido.getFechaCreacion());
		pedidoDto.setEstatus(pedido.getEstatus());	
		return pedidoDto;

	}
	
	    public Pedido dtoToEntity(PedidoDTO pedidoDto) {
		if(pedidoDto==null){
			return null;
		}
		
		Pedido pedido= new Pedido();
		
		pedido.setId(pedidoDto.getId());
		pedido.setCliente(pedidoDto.getCliente());
		pedido.setProductos(pedidoDto.getProductos());
		pedido.setTotal(pedidoDto.getTotal());
		pedido.setFechaCreacion(pedidoDto.getFechaCreacion());
		pedido.setEstatus(pedidoDto.getEstatus());
		return pedido;
	
	}

}
