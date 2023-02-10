package com.eventcontrol.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class AsistentesDto {
	
	private Long id;	
	private String nombre;
	private String email;	
	private String numIdentificacion;
}
