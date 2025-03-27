package com.alayn.pedidos.dto;

import java.util.Date;
import java.util.List;

import com.alayn.commons.models.entities.Cliente;

import com.alayn.commons.models.entities.Producto;


public class PedidoDTO {

		private long id;
	
		private Cliente cliente;
	
		private List<Producto> productos;
		

		private Double total;

	    private Date fechaCreacion;

	    private long estatus;

		public long getId() {
			return id;
		}


		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> list) {
			this.productos = list;
		}
		public void setId(long id) {
			this.id = id;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public Date getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public long getEstatus() {
			return estatus;
		}

		public void setEstatus(long estatus) {
			this.estatus = estatus;
		}
	    
	    
	    
	

}
