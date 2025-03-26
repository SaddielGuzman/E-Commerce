package com.alayn.commons.models.entities;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

   
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_LISTA_PRODUCTOS")
    @JsonManagedReference
    private ListaProductos listaProductos;
    
    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "ESTATUS")
    private String estatus;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public ListaProductos getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ListaProductos listaProductos) {
		this.listaProductos = listaProductos;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", listaProductos=" + listaProductos
				+ ", total=" + total + ", fechaCreacion=" + fechaCreacion + ", estatus=" + estatus + "]";
	}

  
}
    
    
    
    
    