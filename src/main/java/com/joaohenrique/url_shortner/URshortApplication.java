package com.joaohenrique.url_shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class URshortApplication {

	public static void main(String[] args) {
		SpringApplication.run(URshortApplication.class, args);
	}

    //Criar RN para data de expiração da url | RN: default 7 dias, front precisa enviar em ISO 8601
    //Criar endpoint para redirecionamento da url criada
    //TODO: Incrementar qtd de urls no usuario

}
