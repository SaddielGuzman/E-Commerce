package com.alayn.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan({"com.alayn.commons.models.entities"})
public class MicroserviciosClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosClientesApplication.class, args);
	}

}
