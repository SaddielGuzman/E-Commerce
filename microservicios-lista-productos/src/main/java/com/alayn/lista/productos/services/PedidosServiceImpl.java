package com.alayn.lista.productos.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alayn.commons.models.entities.Pedido;
import com.alayn.commons.services.CommonServiceImpl;
import com.alayn.pedidos.dto.PedidoDTO;
import com.alayn.pedidos.mapper.PedidoMapper;
import com.alayn.pedidos.models.repositories.PedidoRepository;


import jakarta.validation.ReportAsSingleViolation;

@Service
public class PedidosServiceImpl extends CommonServiceImpl <Pedido, PedidoRepository> implements PedidoService{
	
	private final PedidoMapper mapper;
	
	public PedidosServiceImpl(PedidoMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public Pedido createPedidoDTO(PedidoDTO pedidoDTO) {
		
		Pedido pedido = mapper.dtoToEntity(pedidoDTO);
			return repository.save(pedido);
	}

	@Override
	@Transactional
	public Pedido update(PedidoDTO pedidoDTO, Long id) {
		
		Optional<Pedido> opt = repository.findById(id);
		if(opt.isPresent()) {
			Pedido pedido = mapper.dtoToEntity(pedidoDTO);
			pedido.setIdPedido(id);
			return repository.save(pedido);
		}
		return null;
	}
}
