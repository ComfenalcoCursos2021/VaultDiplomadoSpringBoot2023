package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventariosApiGradleApplication extends SpringBootServletInitializer {

	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(InventariosApiGradleApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(InventariosApiGradleApplication.class, args);
	}

}
