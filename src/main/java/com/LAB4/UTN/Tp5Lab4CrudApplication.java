package com.LAB4.UTN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.LAB4.UTN.properties.FileStorageProperties;

@SpringBootApplication

@EnableConfigurationProperties({ FileStorageProperties.class })
public class Tp5Lab4CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp5Lab4CrudApplication.class, args);
	}

}
