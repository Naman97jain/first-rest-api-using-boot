package com.rest.api;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class FirstRestApiUsingBootApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FirstRestApiUsingBootApplication.class, args);
		System.out.println("Started....");
	}
}




