package com.diplomado.ventas.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductoModel {
	private int id;	
	private String nombre;	
	private double precioCosto;	
	private double precioVenta;	
}
