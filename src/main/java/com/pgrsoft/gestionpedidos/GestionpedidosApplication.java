package com.pgrsoft.gestionpedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.pgrsoft.gestionpedidos.backend.pruebas.filestorage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GestionpedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionpedidosApplication.class, args);
	}
}
