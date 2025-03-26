package com.alayn.lista.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.alayn.commons.models.entities"})
public class MicroserviciosListaProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosListaProductosApplication.class, args);
	}

}
