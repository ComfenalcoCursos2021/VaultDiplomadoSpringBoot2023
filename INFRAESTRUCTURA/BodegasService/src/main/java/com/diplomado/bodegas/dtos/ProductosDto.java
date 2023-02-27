

package com.diplomado.bodegas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductosDto {

		
		private int id;
		
		private String nombre;	
		
		private double precioCosto;	
		
		private double precioVenta;	
	
}




