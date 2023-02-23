package com.marqueserick.api.denuncia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DenunciaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DenunciaApiApplication.class, args);
	}

}
