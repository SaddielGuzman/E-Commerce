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
        listaProductoDTO.setProductos(listaProductos.getProductos()); // Copiar la lista de productos
        return listaProductoDTO;
    }

    public ListaProductos dtoToEntity(ListaProductoDTO listaProductoDTO) {
        if (listaProductoDTO == null) {
            return null;
        } else {
            ListaProductos listaProductos = new ListaProductos();
            listaProductos.setIdListaProductos(listaProductoDTO.getIdListaProductos());
            listaProductos.setProductos(listaProductoDTO.getProductos()); // Copiar la lista de productos
            return listaProductos;
        }
    }
}