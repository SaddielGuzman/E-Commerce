package com.alayn.pedidos.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alayn.commons.models.entities.Pedido;
import com.alayn.commons.services.CommonServiceImpl;
import com.alayn.pedidos.dto.PedidoDTO;
import com.alayn.pedidos.mapper.PedidoMapper;
import com.alayn.pedidos.models.repositories.PedidoRepository;

@Service
public class pedidosServiceImpl extends CommonServiceImpl<Pedido, PedidoRepository> implements PedidoService{
	
	private final PedidoMapper mapper;

	public pedidosServiceImpl(PedidoMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	
	@Override
	@Transactional
	public Pedido createPedidoDTO(PedidoDTO pedidoDTO) {
		Pedido pedido =mapper.dtoToEntity(pedidoDTO);
		return repository.save(pedido);
	}


	@Transactional
	@Override
	public Pedido actualizar(Pedido pedido, Long id) {
		Optional<Pedido> optPedido=repository.findById(id);
		if(optPedido.isPresent()) {
			Pedido pedidoDb=optPedido.get();
			pedidoDb.setCliente(pedido.getCliente());
			pedidoDb.setFechaCreacion(pedido.getFechaCreacion());
			pedidoDb.setProductos(pedido.getProductos());
			pedidoDb.setTotal(pedido.getTotal());
			pedidoDb.setEstatus(pedido.getEstatus());
			repository.save(pedidoDb);
		
				
			return pedidoDb;
		}
		
		return null;
	}
	
	
	
}
