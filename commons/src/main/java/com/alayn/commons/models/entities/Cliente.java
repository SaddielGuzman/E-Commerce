package com.alayn.commons.models.entities;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;




@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	

	
    @Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="CLIENTES_SEQ")
	@SequenceGenerator(name="CLIENTES_SEQ", sequenceName ="CLIENTES_SEQ", allocationSize = 1 )
	@Column(name= "ID_CLIENTE")
	private long id;
    
    
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
   	@Size(min=1,max=20,message="El numero debe tener maximo 20 caracteres")
	private String telefono;
    
    @Column(name= "DIRECCION")
    @Size(max=50)
	private String direccion;
    
     @OneToMany(mappedBy="cliente")
     @JsonManagedReference    
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	@PrePersist
	public void prePersist() {
	    if(this.pedidos == null) {
	        this.pedidos = new ArrayList<>();
	    }
	}



    

}
