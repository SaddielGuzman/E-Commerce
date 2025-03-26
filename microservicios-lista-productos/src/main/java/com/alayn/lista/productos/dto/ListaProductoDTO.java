package com.alayn.lista.productos.dto;

import java.util.List;


import com.alayn.commons.models.entities.ListaProductos.ProductoItem;
import com.alayn.commons.models.entities.Pedido;

public class ListaProductoDTO {

    private Long idListaProductos;
    private List<ProductoItem> productosItems;
    private Pedido pedido; 
	public Long getIdListaProductos() {
		return idListaProductos;
	}
	public void setIdListaProductos(Long idListaProductos) {
		this.idListaProductos = idListaProductos;
	}
	public List<ProductoItem> getProductosItems() {
		return productosItems;
	}
	public void setProductosItems(List<ProductoItem> productosItems) {
		this.productosItems = productosItems;
	}

	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "ListaProductoDTO [idListaProductos=" + idListaProductos + ", productosItems=" + productosItems
				+ ", pedido=" + pedido + "]";
	}

	
}