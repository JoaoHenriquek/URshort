package com.joaohenrique.url_shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class URshortApplication {

	public static void main(String[] args) {
		SpringApplication.run(URshortApplication.class, args);
	}

    //TODO: Criar RN para data de expiração da url
    //TODO: Criar endpoint para redirecionamento da url criada

}
