package com.jagger.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Jagger06ServiceRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jagger06ServiceRegistrationApplication.class, args);
	}

}
