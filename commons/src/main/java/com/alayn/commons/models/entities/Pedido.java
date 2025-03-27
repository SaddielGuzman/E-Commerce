package com.alayn.commons.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PEDIDOS")
public class Pedido {	
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="PEDIDOS_SEQ")
	@SequenceGenerator(name="PEDIDOS_SEQ", sequenceName ="PEDIDOS_SEQ", allocationSize = 1 )
	@Column(name= "ID_PEDIDO")
	private long id;
	
	@ManyToOne
	@JoinColumn(name= "ID_CLIENTE")
	 @JsonBackReference	
	private Cliente cliente;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name="PRODUCTOS_PEDIDOS", joinColumns =@JoinColumn(name="ID_PEDIDO", referencedColumnName = "ID_PEDIDO"),
	inverseJoinColumns = @JoinColumn(name="ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO"))
	private List<Producto> productos;
	
	@Column(name = "TOTAL")
	private Double total;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    
    @Column(name = "ESTATUS")
    private long estatus;

    

	public Pedido() {
		this.productos = new ArrayList<>();
	}


	public long getId() {
		return id;
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


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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

