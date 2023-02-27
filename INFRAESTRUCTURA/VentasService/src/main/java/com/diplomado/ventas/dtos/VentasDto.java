

package com.diplomado.ventas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class VentasDto {

		
		private int id;
		
		private int clientesId;	
		
		private String numero;	
	
}




