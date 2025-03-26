package com.alayn.lista.productos.mapper;

import org.springframework.stereotype.Component;

import com.alayn.commons.models.entities.ListaProductos;
import com.alayn.lista.productos.dto.ListaProductoDTO;

@Component
public class ListaProductosMapper {

    public ListaProductoDTO entityToDTO(ListaProductos listaProductos) {
        if (listaProductos == null) {
            return null;
        }
        ListaProductoDTO listaProductoDTO = new ListaProductoDTO();
        listaProductoDTO.setIdListaProductos(listaProductos.getIdListaProductos());
        listaProductoDTO.setProductosItems(listaProductos.getProductosItems());
        listaProductoDTO.setPedido(listaProductos.getPedido());
        return listaProductoDTO;
    }

    public ListaProductos dtoToEntity(ListaProductoDTO listaProductoDTO) {
        if (listaProductoDTO == null) {
            return null;
        } else {
            ListaProductos listaProductos = new ListaProductos();
            listaProductos.setIdListaProductos(listaProductoDTO.getIdListaProductos());
            listaProductos.setProductosItems(listaProductoDTO.getProductosItems());
            listaProductos.setPedido(listaProductoDTO.getPedido());
            return listaProductos;
        }
    }
}