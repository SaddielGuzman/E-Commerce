package com.alayn.lista.productos.mapper;

import org.springframework.stereotype.Component;

import com.alayn.commons.models.entities.Pedido;
import com.alayn.commons.models.entities.ListaProductos;
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
        if (pedido.getListaProductos() != null) {
            pedidoDTO.setIdListaProductos(pedido.getListaProductos().getIdListaProductos());
        }
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
            ListaProductos listaProductos = new ListaProductos();
            listaProductos.setIdListaProductos(pedidoDTO.getIdListaProductos());
            pedido.setListaProductos(listaProductos);
            pedido.setTotal(pedidoDTO.getTotal());
            pedido.setFechaCreacion(pedidoDTO.getFechaCreacion());
            pedido.setEstatus(pedidoDTO.getEstatus());
            return pedido;
        }
    }
}