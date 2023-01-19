package com.example.demo.dtos;

import com.example.demo.entities.UserEntity;

public class UserDto {
	
	private long id;	
	private String nombre;	
	private String apellido;	
	private String email;
	private int edad; 
	
	public UserDto() {}
	
	public UserDto(UserEntity user) {
		this.id = user.getId();
		this.nombre = user.getNombre();
		this.apellido = user.getApellido();
		this.email = user.getEmail();
		this.edad = user.getEdad();
	}

	public UserDto(Long id, String nombre, String apellido, String email, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
