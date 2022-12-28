package com.jagger.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient(autoRegister = true)
@SpringBootApplication
public class Jagger02Application {

	public static void main(String[] args) {
		SpringApplication.run(Jagger02Application.class, args);
	}

}
