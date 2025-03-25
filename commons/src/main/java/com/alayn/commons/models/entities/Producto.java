package com.alayn.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	private Long idProducto;
    
    
    @Column(name= "NOMBRE")
	@NotBlank(message = "EL NOMBRE DEL PRODUCTO ES OBLIGATORIO")
	@Size(min=1,max=50,message="EL NOMBRE NO PUEDE TENER MAS DE 50 CARACTERES Y MENOS DE 1")
	private String NOMBRE;
    
    
    @Column(name= "DESCRIPCION")
   	@NotBlank(message = "LA DESCRIPPCION ES OBLIGATORIA")
   	@Size(min=1,max=50,message="LA DESCRIPCION NO PUEDE SER MAYOR A 50 CARACTERES")
	private String DESCRIPCION;
    
    
    @Column(name = "PRECIO")
    @NotNull(message = "EL PRECIO DEL PRODUCTO ES OBLIGATORIO") 
    @Min(value = 1, message = "EL PRECIO DEBE SER MAYOR A 0")
    private Integer PRECIO;
    
    
    @Column(name = "STOCK")
    @NotNull(message = "EL STOCK DEL PRODUCTO ES OBLIGATORIO") 
    @Min(value = 1, message = "EL ESTOCK NO PUEDE SER NEGATIVO")
    private Integer STOCK;


	public long getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return NOMBRE;
	}


	public void setNombre(String nombre) {
		this.NOMBRE = nombre;
	}


	public String getDESCRIPCION() {
		return DESCRIPCION;
	}


	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}


	public Integer getPRECIO() {
		return PRECIO;
	}


	public void setPRECIO(Integer pRECIO) {
		PRECIO = pRECIO;
	}


	public Integer getSTOCK() {
		return STOCK;
	}


	public void setSTOCK(Integer sTOCK) {
		STOCK = sTOCK;
	}
    

    

    
}
