

package com.diplomado.bodegas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ExistenciasDto {

		
		private int id;
		
		private int cantidad;	
		
		private String existenciascol;	
		
		private int idBodega;	
		
		private int idProducto;	
	
}




