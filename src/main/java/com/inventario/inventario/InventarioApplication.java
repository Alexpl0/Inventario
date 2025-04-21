package com.inventario.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//netstat -ano | findstr :8080
// taskkill /PID 26956 /F

@SpringBootApplication
public class InventarioApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

}
