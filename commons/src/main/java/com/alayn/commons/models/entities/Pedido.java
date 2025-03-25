package com.alayn.commons.models.entities;

import java.time.LocalDate;

import com.alayn.commons.models.entity.Aerolinea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="PEDIDOS")
public class Pedido {
	
	

	
    @Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="PEDIDOS_SEQ")
	@SequenceGenerator(name="PEDIDOS_SEQ", sequenceName ="PEDIDOS_SEQ", allocationSize = 1 )
	@Column(name= "ID_PEDIDO")
	private long idPedido;
    
    
    @Column(name= "ID_CLIENTE")
	@NotBlank(message = "EL ID DEL CLIENTE ES OBLIGATORIO")
	private Long idCliente;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_LISTA_PRODUCTOS") 
    @NotNull(message = "LA LISTA DE PRODUCTOS ES OBLIGATORIA") 
    private ListaProductos listaProductos;
    
    @Column(name= "TOTAL")
   	@NotBlank(message = "EL TOTAL DEBE SER MAYOR A 0")
   	@Size(min=1,max=50,message="El email debe tener entre 1 y 50 caracteres")
	private String total;
    
    @Column(name= "FECHA_CREACION")
   	@NotBlank(message = "DEBE DE TENER FECHA")
	@Past(message = "LA FECHA DEL PRIMER VUELO DEBE SER ANTERIOR A LA FECHA ACTUAL")
	private LocalDate fechaCreacion;
    
    
    @Column(name = "ESTATUS")
	@NotNull(message = "EL ESTATUS ES OBLIGATORIO")
	@Min(value = 1, message = "EL ESTATUS DEBE SER AL MENOS 1")
	@Max(value = 4, message = "EL ESTATUS NO DEBE SER MAYOR A 4")
	private Long estatus;


	public long getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}


	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public Long getIdListaProductos() {
		return idListaProductos;
	}


	public void setIdListaProductos(Long idListaProductos) {
		this.idListaProductos = idListaProductos;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Long getEstatus() {
		return estatus;
	}


	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}




}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    