package com.pos.dtos;

import com.pos.entities.UnidadMedidaEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class UnidadMedidaDto {
	
	private Long id;
	
	
	@Size(min = 5, max = 20, message = "NO TIENE LA LONGITUD CORRECTA")
	private String descripcion;
}
