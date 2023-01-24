package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user",nullable = false, unique = true)
	
	private Long id;
	@Column(name="nombre",length=50)
	private String nombre;
	@Column(length=50)
	private String apellido;
	@Column(length=50, unique = true)
	private String email;
	@Column(name="edad")
	private int edad;
	
	
	@Column(name="id_user_mod")
	private Long idUserMod;
	@Column(name="ultima_modificacion")
	private Date ultimaModificacion;
	@Column(name="ultimo_contenido",length=500)
	private String ultimoContenido;
	
	public UserEntity() {
		loadAuditoria();
	}
	public UserEntity(String nombre, String apellido, String email, int edad) {	
		loadAuditoria();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
	}
	
	private void loadAuditoria() {
		this.idUserMod = 99L;
		this.ultimaModificacion = new Date();
		this.ultimoContenido = "{{}}";
	}
	
	
	
	
}
