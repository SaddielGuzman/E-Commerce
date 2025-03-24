package com.alayn.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.alayn.commons.models.entity"})
public class MicroserviciosPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPedidosApplication.class, args);
	}

}
