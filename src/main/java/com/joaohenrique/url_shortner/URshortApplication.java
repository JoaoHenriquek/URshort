package com.joaohenrique.url_shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class URshortApplication {

	public static void main(String[] args) {
		SpringApplication.run(URshortApplication.class, args);
	}

    //RN data expiração URL: default 7 dias | NOTE: front precisa enviar data em ISO 8601
}
