package com.alayn.commons.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="PRODUCTOS")
public class Producto {
	
	
	
    @Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="PRODUCTOS_SEQ")
	@SequenceGenerator(name="PRODUCTOS_SEQ", sequenceName ="PRODUCTOS_SEQ", allocationSize = 1 )
	@Column(name= "ID_PRODUCTO")
	private long id;
    
   
    
    
    @Column(name= "NOMBRE")
	@NotBlank(message = "El nombre del producto es obligatorio")
	@Size(min=1,max=50,message="El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
    
    
    @Column(name= "DESCRIPCION")
   	@NotBlank(message = "La descripciondel producto es obligatorio")
   	@Size(min=1,max=50,message="la descripcion debe tener entre 1 y 100 caracteres")
	private String descripcion;
    
    
    @Column(name= "PRECIO")
	@NotNull(message = "El precio es obligatorio")
    @Min(value=0, message="El precio no puede ser menos de 1")
	private double precio;
    
    @Column(name= "STOCK")
    @NotNull(message = "El numero de stock es obligatorio")
    @Min(value=0, message="El stock no puede ser menos de 0")
	private Integer stock;
   
    @ManyToMany(mappedBy = "productos")
    private List<Pedido> pedidos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	


    
    
    

    
}
