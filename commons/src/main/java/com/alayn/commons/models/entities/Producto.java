package com.alayn.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="PRODUCTO")
public class Producto {
	
    @Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="CLIENTES_SEQ")
	@SequenceGenerator(name="CLIENTES_SEQ", sequenceName ="CLIENTES_SEQ", allocationSize = 1 )
	@Column(name= "CLIENTES_SEQ")
	private long idCliente;
    
    
    @Column(name= "NOMBRE")
	@NotBlank(message = "El nombre del cliente es obligatorio")
	@Size(min=1,max=50,message="El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
    
    
    @Column(name= "APELLIDO")
   	@NotBlank(message = "El apellido del cliente es obligatorio")
   	@Size(min=1,max=50,message="El apellido debe tener entre 1 y 50 caracteres")
	private String apellido;
    
    
    @Column(name= "EMAIL")
   	@NotBlank(message = "El email del cliente es obligatorio")
   	@Size(min=1,max=50,message="El email debe tener entre 1 y 50 caracteres")
	private String eMail;
    
    @Column(name= "TELEFONO")
   	@NotBlank(message = "El telefono del cliente es obligatorio")
   	@Size(min=1,max=10,message="El numero debe tener 10 caracteres")
	private String Telefono;
    
    @Column(name= "DIRECCION")
   	@Size(min=1,max=50,message="La direccion no debe de contener mas de 50 caracteres")
	private String Direccion;

    
}
