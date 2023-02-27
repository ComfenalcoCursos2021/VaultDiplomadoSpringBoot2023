

package com.diplomado.ventas.dtos;

import com.diplomado.ventas.model.ProductoModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class VentasDetalleDto {

		
		private int id;		
		private int productosId;		
		private int ventasId;			
		private ProductoModel producto;
	
}




