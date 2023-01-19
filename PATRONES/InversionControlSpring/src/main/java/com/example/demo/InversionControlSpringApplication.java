package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.UserEntity;
import com.example.demo.repositorio.IUserRepositorio;

@SpringBootApplication
public class InversionControlSpringApplication implements CommandLineRunner {

	private IUserRepositorio userRepositorio;
	
	public InversionControlSpringApplication(IUserRepositorio userRepositorio) {
		this.userRepositorio = userRepositorio;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InversionControlSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		List<UserEntity> lista= new ArrayList<UserEntity>();
		
		for (int i = 1; i <= 2; i++) {
			UserEntity nuevo = new UserEntity("El nombre "+i+"", "El apellido "+i+"", "correo"+i+"@correo.com",i+10);
			lista.add(nuevo);
		}
		
		lista.stream().forEach(this.userRepositorio::save);
		
		
		
		System.out.println("termino la funcion run");
		
	}

}
