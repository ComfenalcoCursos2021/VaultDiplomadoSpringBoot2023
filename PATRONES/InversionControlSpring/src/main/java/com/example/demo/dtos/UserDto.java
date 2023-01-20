package com.example.demo.dtos;

import lombok.Data;

@Data
public class UserDto {
	
	private long id;	
	private String nombre;	
	private String apellido;	
	private String email;
	private int edad; 
	
	
	public UserDto() {}	

	public UserDto(Long id, String nombre, String apellido, String email, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
	}

	
}
