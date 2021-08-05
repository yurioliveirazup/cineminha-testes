package br.com.zup.edu.cineminhatestes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CineminhaTestesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineminhaTestesApplication.class, args);
	}

}
