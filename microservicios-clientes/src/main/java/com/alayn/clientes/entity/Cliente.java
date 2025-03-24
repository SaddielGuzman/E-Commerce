package com.alayn.clientes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	
	private long idCliente;
	private String nombre;
	private String apellido;
	private String eMail;
	private String Telefono;
	private String Direccion;

}
