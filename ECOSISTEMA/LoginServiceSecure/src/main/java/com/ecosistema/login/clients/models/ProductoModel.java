package com.ecosistema.login.clients.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductoModel {
	private Long id;
	private String nombre;
	private double precio;
}
