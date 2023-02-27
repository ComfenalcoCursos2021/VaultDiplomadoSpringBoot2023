

package com.diplomado.bodegas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BodegasDto {

		
		private int id;
		
		private int capacidad;	
		
		private String codigo;	
		
		private String nombre;	
	
}




