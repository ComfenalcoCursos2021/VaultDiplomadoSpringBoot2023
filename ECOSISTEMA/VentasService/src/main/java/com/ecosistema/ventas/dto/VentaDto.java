package com.ecosistema.ventas.dto;

import com.ecosistema.ventas.clients.models.ProductoModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class VentaDto {
	private Long id;	
	private String nombreCliente;
	private double precioVenta;	
	private long idProducto;
	
	private ProductoModel producto;
}
