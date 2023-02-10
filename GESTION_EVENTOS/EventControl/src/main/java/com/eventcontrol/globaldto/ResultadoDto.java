package com.eventcontrol.globaldto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class ResultadoDto<T> {
	private boolean todoOk;
	private T data;
	private String errorMessage;
	
	public static <T> ResultadoDto ok(T data) {
		return ResultadoDto.builder().data(data).todoOk(true).build();
	}
	public static <T> ResultadoDto Falla() {
		return ResultadoDto.builder().todoOk(false).build();
	}
	public static <T> ResultadoDto Falla(Exception e) {
		
		return ResultadoDto.builder().todoOk(false).errorMessage(e.getMessage()).build();
	}
	
}
