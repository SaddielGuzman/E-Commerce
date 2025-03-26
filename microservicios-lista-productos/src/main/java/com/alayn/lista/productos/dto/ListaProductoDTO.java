package com.alayn.lista.productos.dto;

import java.util.List;
import com.alayn.commons.models.entities.ListaProductos.ProductoItem;

public class ListaProductoDTO {

    private Long idListaProductos;
    private List<ProductoItem> productos; 

    public Long getIdListaProductos() {
        return idListaProductos;
    }

    
    public void setIdListaProductos(Long idListaProductos) {
        this.idListaProductos = idListaProductos;
    }

    public List<ProductoItem> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoItem> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "ListaProductoDTO [idListaProductos=" + idListaProductos + ", productos=" + productos + "]";
    }
}