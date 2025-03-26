package com.alayn.lista.productos.services;

import com.alayn.commons.models.entities.ListaProductos;
import com.alayn.commons.services.CommonService;
import com.alayn.lista.productos.dto.ListaProductoDTO;

public interface ListaProductosService extends CommonService<ListaProductos> {

    ListaProductos createListaProductoDTO(ListaProductoDTO listaProductoDTO);

    ListaProductos update(ListaProductoDTO listaProductoDTO, Long id);
}