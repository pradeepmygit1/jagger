package com.jagger.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient(autoRegister = true)
@SpringBootApplication
public class Jagger05GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jagger05GatewayApplication.class, args);
	}

}
