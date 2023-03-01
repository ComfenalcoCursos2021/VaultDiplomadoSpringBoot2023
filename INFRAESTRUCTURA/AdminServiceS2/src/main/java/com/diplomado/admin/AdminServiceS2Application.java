package com.diplomado.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminServiceS2Application  {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceS2Application.class, args);
	}

}
