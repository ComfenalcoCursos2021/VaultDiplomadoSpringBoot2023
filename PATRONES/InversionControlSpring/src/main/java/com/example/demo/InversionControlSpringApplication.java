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
		
		
		ClasesAnteriores();
		buscarTesting();
		System.out.println("termino la funcion run");
		
	}
	private void buscarTesting() {
		List<UserEntity> usuarios = userRepositorio.bucarNombreApellido("", "El apellido 11");		
		usuarios.stream().forEach( user -> System.out.println("USUARIO BUSCADO TESTING  -> " + user));
		
		
		usuarios = userRepositorio.findByNombreOrApellido("", "El apellido 11");		
		usuarios.stream().forEach( user -> System.out.println("USUARIO BUSCADO QUERYMETHOD  -> " + user));
		
		
		usuarios = userRepositorio.findByEdadBetween(18,22);		
		usuarios.stream().forEach( user -> System.out.println("USUARIO BUSCADO QUERYMETHOD  -> " + user));
	}
	

	private void ClasesAnteriores() {
		List<UserEntity> lista= new ArrayList<UserEntity>();
		
		for (int i = 1; i <= 1; i++) {
			UserEntity nuevo = new UserEntity("El nombre "+i+"", "El apellido "+i+"", "correo"+i+"@correo.com",i+10);
			lista.add(nuevo);
		}
		
		lista.stream().forEach(this.userRepositorio::save);
		
		List<UserEntity> lista2 = userRepositorio.findByEdad(11,15); 
		
		for (UserEntity userEntity : lista2) {
			System.out.println(userEntity);
		}
		
		lista2 = userRepositorio.findByNombre("El nombre 11"); 
		
		for (UserEntity userEntity : lista2) {
			System.out.println(userEntity);
		}
	}

}
