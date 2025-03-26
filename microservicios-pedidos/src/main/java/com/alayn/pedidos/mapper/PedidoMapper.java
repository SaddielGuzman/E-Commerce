package com.alayn.pedidos.mapper;

import org.springframework.stereotype.Component;

import com.alayn.commons.models.entities.Pedido;
import com.alayn.pedidos.dto.PedidoDTO;

@Component
public class PedidoMapper {

    public PedidoDTO entityToDTO(Pedido pedido) {
        if (pedido == null) {
            return null;
        }
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setIdPedido(pedido.getIdPedido());
        pedidoDTO.setIdCliente(pedido.getIdCliente());
        pedidoDTO.setTotal(pedido.getTotal());
        if (pedido.getFechaCreacion() != null) {
            pedidoDTO.setFechaCreacion(new java.sql.Date(pedido.getFechaCreacion().getTime())); 
        }
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
            pedido.setTotal(pedidoDTO.getTotal());
            if (pedidoDTO.getFechaCreacion() != null) {
                pedido.setFechaCreacion(new java.util.Date(pedidoDTO.getFechaCreacion().getTime())); 
            }
            pedido.setEstatus(pedidoDTO.getEstatus());
            return pedido;
        }
    }
}