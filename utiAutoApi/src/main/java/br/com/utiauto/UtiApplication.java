	package br.com.utiauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class UtiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtiApplication.class, args);
	}

}
