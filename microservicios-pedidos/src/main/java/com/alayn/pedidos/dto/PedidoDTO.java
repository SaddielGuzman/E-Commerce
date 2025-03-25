package com.alayn.pedidos.dto;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class PedidoDTO {
	
	

	private long idPedido;
    
    

	@NotBlank(message = "EL ID DEL CLIENTE ES OBLIGATORIO")
	private Long idCliente;
    
    
 
   	@NotBlank(message = "EL ID DE LA LISTA PRODUCTOS ES OBLIGATORIO")
	private Long idListaProductos;
    
  
   	@NotBlank(message = "EL TOTAL DEBE SER MAYOR A 0")
   	@Size(min=1,max=50,message="El email debe tener entre 1 y 50 caracteres")
	private String total;
    
   
   	@NotBlank(message = "DEBE DE TENER FECHA")
	@Past(message = "LA FECHA DEL PRIMER VUELO DEBE SER ANTERIOR A LA FECHA ACTUAL")
	private LocalDate fechaCreacion;
    
    
  
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




	@Override
	public String toString() {
		return "PedidoDTO [idPedido=" + idPedido + ", idCliente=" + idCliente + ", idListaProductos=" + idListaProductos
				+ ", total=" + total + ", fechaCreacion=" + fechaCreacion + ", estatus=" + estatus + "]";
	}






	
	
}