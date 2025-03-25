package com.alayn.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EntityScan("com.alayn.commons.models.entities")
public class MicroserviciosPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPedidosApplication.class, args);
	}

}
